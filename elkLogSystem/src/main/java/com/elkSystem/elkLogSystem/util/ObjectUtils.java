package com.elkSystem.elkLogSystem.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Service
@Slf4j
public class ObjectUtils {

    public String getObjId(Object obj){
        try{
            Method getterId = obj.getClass().getMethod("getId");
            Object id = getterId.invoke(obj);

            Method toString = id.getClass().getMethod("toString");
            String objId = (String) toString.invoke(id);
            return objId;
        } catch (NoSuchMethodException noSuchMethodException){
            log.error("Object not implements getId method");
            return null;
        } catch (InvocationTargetException invocationTargetException){
            log.error(invocationTargetException.getMessage());
            return null;
        } catch (IllegalAccessException illegalAccessException){
            log.error(illegalAccessException.getMessage());
            return null;
        }
    }
}
