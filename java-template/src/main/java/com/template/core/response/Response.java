package com.template.core.response;

/**
 * Created by finley on 2/7/17.
 */
public abstract class Response {

    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public static enum Result {
        Normal, Error
    }

    public abstract String getContent();

}
