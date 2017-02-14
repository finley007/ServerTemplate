package com.template.exception;

import com.template.core.exception.BusinessException;

/**
 * Created by finley on 2/8/17.
 */
public class InvalidRequestException extends BusinessException {

    public InvalidRequestException(String msg) {
        super(msg);
    }
}
