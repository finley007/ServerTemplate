package com.template.core.response;

import com.template.core.payload.Payload;

/**
 * Created by finley on 2/7/17.
 */
public class ErrorResponse extends Response {

    public ErrorResponse(String errorMsg) {
        this.setResult(Result.Error);
        this.errorMsg = errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    private String errorMsg;

    public String getContent() {
        return this.errorMsg;
    }

    public String build() {
        return new Payload(this).from(this.getClass());
    }

}
