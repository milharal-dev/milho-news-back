package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Index {
    @JsonProperty("byteEnd")
    public Integer byteEnd;

    @JsonProperty("byteStart")
    public Integer byteStart;

    public Integer getByteEnd() {
        return byteEnd;
    }

    public void setByteEnd(Integer byteEnd) {
        this.byteEnd = byteEnd;
    }

    public Integer getByteStart() {
        return byteStart;
    }

    public void setByteStart(Integer byteStart) {
        this.byteStart = byteStart;
    }
}

