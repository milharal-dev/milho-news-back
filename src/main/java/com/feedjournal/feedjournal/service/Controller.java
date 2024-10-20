package com.feedjournal.feedjournal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedjournal.feedjournal.model.Feed;
import com.feedjournal.feedjournal.model.FeedItem;
import com.feedjournal.feedjournal.config.HttpHelper;
import com.feedjournal.feedjournal.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class Controller {

    private final HttpHelper httpHelper;

    public Controller(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @GetMapping
    public List<FeedItem> getFeed() throws IOException, InterruptedException {
        List<FeedItem> feedItems = new ArrayList<>() ;

        String FeedUrl = "https://public.api.bsky.app/xrpc/app.bsky.feed.getFeed";
        String FeedId = "at://did:plc:mup34dteco2xkrzq4xxkkz7h/app.bsky.feed.generator/aaak3fykvnfik";
        String Cursor = "";

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("feed", FeedId);

        String response = httpHelper.get(FeedUrl, queryParams, null);

        ObjectMapper mapper = new ObjectMapper();
        Feed feed = mapper.readValue(response, Feed.class);

        feedItems.addAll(feed.getFeedItems());

        while (feed.cursor != null) {
            queryParams.put("cursor", feed.cursor);
            response = httpHelper.get(FeedUrl, queryParams, null);
            feed = mapper.readValue(response, Feed.class);
            feedItems.addAll(feed.getFeedItems());
        }

        return feedItems;
    }

    @GetMapping("/RelevantPotopsts")
    public List<Post> getTopRelevantPosts() throws IOException, InterruptedException {
        List<FeedItem> feedItems = getFeed();

        return feedItems.stream()
                .map(FeedItem::getPost)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingDouble(Post::calculateRelevance).reversed())
                .limit(7)
                .collect(Collectors.toList());
    }

}
