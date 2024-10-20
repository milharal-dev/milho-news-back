package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    @JsonProperty("uri")
    public String uri;

    @JsonProperty("cid")
    public String cid;

    @JsonProperty("author")
    public Author author;

    @JsonProperty("record")
    public Record record;

    @JsonProperty("embed")
    public Embed embed;

    @JsonProperty("replyCount")
    public Integer replyCount;

    @JsonProperty("repostCount")
    public Integer repostCount;

    @JsonProperty("likeCount")
    public Integer likeCount;

    @JsonProperty("quoteCount")
    public Integer quoteCount;

    @JsonProperty("indexedAt")
    public Date indexedAt;

    @JsonProperty("labels")
    public List<Object> labels;

    public double calculateRelevance() {
        double likeScore = (likeCount != null) ? likeCount * 1 : 0;
        double repostScore = (repostCount != null) ? repostCount * 2 : 0;
        double replyScore = (replyCount != null) ? replyCount * 1.5 : 0;
        double quoteScore = (quoteCount != null) ? quoteCount * 1 : 0;
        return likeScore + repostScore + replyScore + quoteScore;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Embed getEmbed() {
        return embed;
    }

    public void setEmbed(Embed embed) {
        this.embed = embed;
    }

    public Date getIndexedAt() {
        return indexedAt;
    }

    public void setIndexedAt(Date indexedAt) {
        this.indexedAt = indexedAt;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getQuoteCount() {
        return quoteCount;
    }

    public void setQuoteCount(Integer quoteCount) {
        this.quoteCount = quoteCount;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Integer getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    public Integer getRepostCount() {
        return repostCount;
    }

    public void setRepostCount(Integer repostCount) {
        this.repostCount = repostCount;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}

