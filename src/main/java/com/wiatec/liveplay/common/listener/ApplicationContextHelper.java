package com.wiatec.liveplay.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @author patrick
 */
public class ApplicationContextHelper implements ApplicationContextAware{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHelper.applicationContext = applicationContext;
        logger.info("start ");
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
