package com.template.component.module2.service;

import com.template.component.module2.request.Module2Service1Request;
import com.template.component.module2.response.Module2Service1Response;
import com.template.component.module2.response.Module2Service2Response;

/**
 * Created by finley on 12/31/16.
 */
public interface Service1 {

    public Module2Service1Response function1(Module2Service1Request request);
    public Module2Service2Response function2(String field1);

}

