package com.elkSystem.elkLogSystem.annotations.impl;

import com.elkSystem.elkLogSystem.util.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class LoggerAnnotation {

    @Pointcut(value = "execution(* *.*(..))")
    public void allMethods() {
    }

    private final ObjectUtils objectUtils;

    @Around("@annotation(com.elkSystem.elkLogSystem.annotations.LogObjectId)")
    public Object logId(ProceedingJoinPoint joinPoint) throws Exception, Throwable{
        Object proceed = joinPoint.proceed();
        Object logObject = handleIfResponseEntity(proceed);
       if (isCollection(logObject)){
           logCollectionIds(logObject);
        } else{
           logObjectId(logObject);
       }
       return proceed;
    }

    private void logCollectionIds(Object obj){
        Collection<Object> collection = (Collection<Object>) obj;
        for(Object object: collection){
            logObjectId(object);
        }
    }

    private Object handleIfResponseEntity(Object obj){
        if(obj instanceof ResponseEntity){
            ResponseEntity<Object> responseEntity = (ResponseEntity<Object>) obj;
            Object object = responseEntity.getBody();
            return object;
        }
        return obj;
    }

    private boolean isCollection(Object obj){
        if(obj instanceof Collection){
            return true;
        }
        return false;
    }

    private void logObjectId(Object obj){
        String objectId = objectUtils.getObjId(obj);
        MDC.put("ObjectID", objectId);
        log.info("Returned object " + obj.getClass());
        MDC.remove("ObjectID");
    }
}
