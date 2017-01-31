package com.template.core.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by finley on 1/16/17.
 */
public class LogUtil {

    static final Logger logger  =  LoggerFactory.getLogger(LogUtil.class);

    public static void info(Class clz, String info) {
        logger.info(info);
    }

    public static void info(Class clz, String format, Object para) {
        logger.info(format, para);
    }

    public static void error(Class clz, String info, Throwable t) {
        logger.error(info, t);
    }
}
