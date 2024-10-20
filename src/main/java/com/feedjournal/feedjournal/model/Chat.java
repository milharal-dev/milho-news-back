package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Chat {
    @JsonProperty("allowIncoming")
    public String allowIncoming;

    public String getAllowIncoming() {
        return allowIncoming;
    }

    public void setAllowIncoming(String allowIncoming) {
        this.allowIncoming = allowIncoming;
    }
}

