package com.template.core.response;

import com.template.core.exception.BaseException;

/**
 * Created by finley on 2/18/17.
 */
public class ErrorResponse {

    private String returnCode;

    private String message;

    public ErrorResponse(BaseException e) {
        this.message = e.getMessage();
        this.returnCode = e.getCode();
    }

}
