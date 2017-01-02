package com.template;

/**
 * Created by liuli on 11/7/2016.
 */
public abstract class Request {

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    protected String token;

}
