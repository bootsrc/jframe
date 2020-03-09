package com.bootsrc.cglib;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info(">>>exe_intercept()");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
