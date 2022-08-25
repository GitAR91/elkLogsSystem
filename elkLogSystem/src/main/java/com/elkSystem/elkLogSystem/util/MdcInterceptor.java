package com.elkSystem.elkLogSystem.util;

import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class MdcInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestId = getCorrelationId();
//        MDC.put("CorrelationId", requestId);
//        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
//        requestWrapper.addHeader("CorrelationId", requestId);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        MDC.remove("CorrelationId");
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
