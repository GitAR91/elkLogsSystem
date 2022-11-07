package com.elkSystem.elkLogSystem.util.interceptors;

import com.elkSystem.elkLogSystem.util.HeaderMapRequestWrapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class RequestIdInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        try{
            MDC.remove("RequestId");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
