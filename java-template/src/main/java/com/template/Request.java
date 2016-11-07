package com.template;

import com.template.serialize.Serializer;

/**
 * Created by liuli on 11/3/2016.
 */
public interface Request {
    public void from(String strReq);
    public void setSerializer(Serializer serializer);
}
