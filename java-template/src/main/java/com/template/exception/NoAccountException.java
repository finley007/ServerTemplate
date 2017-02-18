package com.template.exception;

import com.template.core.exception.BusinessException;

/**
 * Created by finley on 2/18/17.
 */
public class NoAccountException extends BusinessException {

    public NoAccountException(String msg) {
        super(msg);
    }

}
