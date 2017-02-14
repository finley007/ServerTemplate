package com.template.exception;

import com.template.core.exception.BusinessException;

/**
 * Created by finley on 2/14/17.
 */
public class InvalidUserException extends BusinessException {

    public InvalidUserException(String msg) {
        super(msg);
    }

}
