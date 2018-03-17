package com.wiatec.liveplay.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuchengpeng on 09/06/2017.
 */
public class LoggerUtil {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger("");
    }


    public static void d (Object message){
        logger.debug("-->  "+message);
    }

    public static void i (Object message){
        logger.info("-->  " + message);
    }

    public static void w (Object message){
        logger.warn("-->  " + message);
    }

    public static void e (Object message){
        logger.error("-->  " + message);
    }
}
