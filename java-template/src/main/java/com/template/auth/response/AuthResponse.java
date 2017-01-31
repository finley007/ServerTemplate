package com.template.auth.response;

/**
 * Created by finley on 1/25/17.
 */
public class AuthResponse {

    public AuthResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public AuthResponse(int code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

    private int code;

    private String message;

    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
