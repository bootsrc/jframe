package com.bootsrc.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods= bean.getClass().getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(My.class)) {
                System.out.println("exe postProcessBeforeInitialization ...");
                My my = method.getAnnotation(My.class);
                String key = my.value();
                System.out.println("my.value()=" + key);

                String data = key + "Data";
                System.out.println("根据key值从MySql, Redis或者Zookeeper中获取对应的配置数据data");
                System.out.println("data=" + data);
                try {
                    method.invoke(bean, data);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        // 这里一般是return bean, 对于@AutowiredAwareBeanPostProcessor, 是 proxy = new Proxy();
        // 最好return proxy   (返回的是bean的代理对象)
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods= bean.getClass().getDeclaredMethods();
        for (Method method : methods){
            if (method.isAnnotationPresent(My.class)) {
                System.out.println("exe postProcessAfterInitialization ...");
            }
        }

        return bean;
    }
}
