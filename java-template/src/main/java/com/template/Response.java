package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/7/2016.
 */
public abstract class Response {

    protected int status;

    public int getStatus() {
        return status;
    }

    public Response setStatus(int status) {
        this.status = status;
        return this;
    }
}
