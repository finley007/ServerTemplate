package com.template.core.exception;

import com.google.gson.Gson;
import com.template.core.tool.Dictionary;
import com.template.core.tool.DictionaryManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by finley on 2/8/17.
 */
public class BaseException extends Exception {

    public BaseException(String msg) {
        super(msg);
    }

    public String getCode() {
        if (DictionaryManager.dic(ExceptionDic.NAME) == null) {
            DictionaryManager.register(ExceptionDic.NAME, new ExceptionDic());
        }
        return ((ExceptionDic) DictionaryManager.dic(ExceptionDic.NAME)).get(this.getClass().getName());
    }

}
