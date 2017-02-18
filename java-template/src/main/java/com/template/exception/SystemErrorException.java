package com.template.exception;

import com.template.core.exception.BusinessException;

/**
 * Created by finley on 2/18/17.
 */
public class SystemErrorException extends BusinessException {

    public SystemErrorException(String msg) {
        super(msg);
    }

}
