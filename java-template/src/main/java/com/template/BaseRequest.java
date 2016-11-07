package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/7/2016.
 */
public abstract class BaseRequest implements Request {

    protected Serializer serializer;

    public void setSerializer(Serializer serializer) {
        this.serializer = serializer;
    }

    public abstract void from(String strReq);
}
