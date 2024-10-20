package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Embed {
    @JsonProperty("$type")
    public String type;

    @JsonProperty("externalView")
    public ExternalView externalView;

    public ExternalView getExternalView() {
        return externalView;
    }

    public void setExternalView(ExternalView externalView) {
        this.externalView = externalView;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}