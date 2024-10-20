package com.feedjournal.feedjournal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Thumb {
    @JsonProperty("$type")
    public String type;

    @JsonProperty("ref")
    public Refs ref;

    @JsonProperty("mimeType")
    public String mimeType;

    @JsonProperty("size")
    public Integer size;

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Refs getRef() {
        return ref;
    }

    public void setRef(Refs ref) {
        this.ref = ref;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
