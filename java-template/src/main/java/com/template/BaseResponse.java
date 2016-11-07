package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/7/2016.
 */
public abstract class BaseResponse implements Response {

    protected Serializer serializer;

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public abstract String toString();

}
