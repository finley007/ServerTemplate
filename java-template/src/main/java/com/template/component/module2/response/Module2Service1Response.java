package com.template.component.module2.response;

/**
 * Created by finley on 1/2/17.
 */
public class Module2Service1Response {

    public Module2Service1Response Module2Service2Response() {
        return this;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result = "ok";

}
