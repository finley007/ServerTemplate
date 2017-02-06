package com.template.core.payload;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mysql.cj.core.util.StringUtils;

/**
 * Created by finley on 2/6/17.
 */
public class Payload {

    private String payload;

    public Payload(String payload) throws Exception {
        if (StringUtils.isNullOrEmpty(payload) || StringUtils.isNullOrEmpty(payload.trim())) {
            throw new Exception();
        }

        this.payload = payload;
    }

    public <T> T as(Class<T> aClass) throws Exception {
        try {
            return new Gson().fromJson(payload, aClass);
        } catch (JsonSyntaxException e) {
            throw new Exception();
        }
    }

}
