package com.wiatec.liveplay.common.mvc;

import com.wiatec.liveplay.common.result.EnumResult;
import com.wiatec.liveplay.common.result.XException;
import com.wiatec.liveplay.common.utils.TextUtil;
import com.wiatec.liveplay.common.listener.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author patrick
 */
public class AuthInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("==================================== before interceptor  ======================================");
        logger.info("= ");
        String ref = request.getHeader("Referer");
        logger.info("= ref = {}", ref);
        if(request.getRequestURI().equals("/liveplay/")){
            return true;
        }
        if(ref == null || !ref.contains("/liveplay")){
            throw new XException(EnumResult.ERROR_RE_LOGIN);
        }
        String username = (String) request.getSession().getAttribute(SessionListener.KEY);
        logger.info("= username = {}", username);
        if(username == null){
            throw new XException(EnumResult.ERROR_RE_LOGIN);
        }
        logger.info("===============================================================================================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(request.getRequestURI().equals("/liveplay/")){
            return;
        }
        String username = (String) request.getSession().getAttribute(SessionListener.KEY);
        if(TextUtil.isEmpty(username)){
            throw new XException(EnumResult.ERROR_RE_LOGIN);
        }
        if(modelAndView != null) {
            modelAndView.getModel().put("username", username);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
