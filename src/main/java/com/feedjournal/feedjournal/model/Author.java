package com.feedjournal.feedjournal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class Author {
    @JsonProperty("did")
    public String did;

    @JsonProperty("handle")
    public String handle;

    @JsonProperty("displayName")
    public String displayName;

    @JsonProperty("avatar")
    public String avatar;

    @JsonProperty("associated")
    public Associated associated;

    @JsonProperty("labels")
    public List<Object> labels;

    @JsonProperty("createdAt")
    public Date createdAt;

    public Associated getAssociated() {
        return associated;
    }

    public void setAssociated(Associated associated) {
        this.associated = associated;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public List<Object> getLabels() {
        return labels;
    }

    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }
}
