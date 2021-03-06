package com.template.component.module2.service;

import com.template.dao.Module2Dao;
import com.template.model.Model2;
import com.template.component.module2.request.Module2Service1Request;
import com.template.component.module2.response.Module2Service1Response;
import com.template.component.module2.response.Module2Service2Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by finley on 12/31/16.
 */
@Service("service1")
public class Service1Impl implements Service1 {

    private Module2Dao module2Dao;

    @Autowired(required = true)
    public void setModule2Dao(Module2Dao module2Dao) {
        this.module2Dao = module2Dao;
    }

    public Module2Service1Response function1(Module2Service1Request request) {
        Model2 model2 = new Model2();
        model2.setField1(request.getField1());
        model2.setField2(request.getField2());
        this.module2Dao.addModel2(model2);
        return new Module2Service1Response();
    }

    public Module2Service2Response function2(String field1) {
        Module2Service2Response response = new Module2Service2Response();
        response.setModel2(this.module2Dao.getModule2ById(field1));
        return response;
    }

}
