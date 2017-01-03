package com.template.module2.request;

import com.template.Request;

/**
 * Created by finley on 1/2/17.
 */
public class Module2Service1Request extends Request {

    private String field1;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Double getField2() {
        return field2;
    }

    public void setField2(Double field2) {
        this.field2 = field2;
    }

    private Double field2;
}
