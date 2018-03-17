package com.wiatec.liveplay.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author patrick
 */
@Component
@Aspect
public class LogAuthService {

    private Logger logger = LoggerFactory.getLogger(LogAuthService.class);

    @Pointcut("execution(public * com.wiatec.panel.service.auth.*.*(..))")
    public void pointCut(){ }

    /**
     * 前置通知
     * @param joinPoint    目标方法对象
     */
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        logger.debug("========================================== service execute ====================================");
        logger.debug("=");
        logger.debug("= class= {}", joinPoint.getSignature().getDeclaringTypeName());
        logger.debug("= method= {}", joinPoint.getSignature().getName());
        for(Object o: joinPoint.getArgs()){
            logger.debug("= args= {}", o.toString());
        }
        logger.debug("= ");
        logger.debug("===============================================================================================");
    }

    /**
     * 异常通知
     * @param exception  发生的异常
     */
    @AfterThrowing(value = "pointCut()" , throwing = "exception")
    public void afterThrowing(Exception exception) {
        logger.debug("======================================= service exception =====================================");
        logger.debug("=");
        logger.debug("= exception= {}", exception.getLocalizedMessage());
        logger.debug("=");
        logger.debug("===============================================================================================");
    }

    /**
     * 返回通知，方法正常执行完没有发生异常后执行的通知
     */
    @AfterReturning(returning = "object", pointcut = "pointCut()")
    public void afterReturning(Object object){
        logger.debug("======================================== service complete =====================================");
        logger.debug("=");
        logger.debug("= response= {}", object);
        logger.debug("=");
        logger.debug("===============================================================================================");
    }

    /**
     * 后置通知
     */
    @After("pointCut()")
    public void after() {

    }

    /**
     * 环绕通知
     * @param joinPoint     代表目标方法对象
     * @throws Throwable    异常
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        //执行在前置通知前
        //do something
        /**
         * joinPoint 作为方法参数传入，代表目标方法对象，使用到此参数时必须要执行proceed，并返回结果
         * 否则实际目标方法将不会执行，在所有的通知方法中都可以使用
         */
        Object result = joinPoint.proceed();
        //执行在后置通知前
        //do something
        return result;
    }

}
