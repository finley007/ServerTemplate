package com.template.auth.response;

/**
 * Created by finley on 1/25/17.
 */
public class AuthResponse {

    public AuthResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;

    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
