package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/3/2016.
 */
public interface Response {
    public String toString();
    public void setSerializer(Serializer serializer);
}
