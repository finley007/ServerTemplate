package com.template.module2.response;

import com.template.Response;
import com.template.model.Model2;
import com.template.module2.Module2;

/**
 * Created by finley on 1/16/17.
 */
public class Module2Service2Response extends Response {

    public Model2 getModel2() {
        return model2;
    }

    public void setModel2(Model2 model2) {
        this.model2 = model2;
    }

    private Model2 model2;
}
