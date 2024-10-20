package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Refs {
    @JsonProperty("link")
    public String link;


    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

