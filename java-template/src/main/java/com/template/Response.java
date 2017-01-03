package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/7/2016.
 */
public abstract class Response {

    protected String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
