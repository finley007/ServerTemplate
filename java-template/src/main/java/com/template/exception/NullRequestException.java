package com.template.exception;

import com.template.core.exception.BusinessException;

/**
 * Created by finley on 2/8/17.
 */
public class NullRequestException extends BusinessException {

    public NullRequestException(String msg) {
        super(msg);
    }

}
