package com.bootsrc.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class StudentAddBean implements ApplicationContextAware {
    private ApplicationContext appContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appContext = applicationContext;
    }

    public void addStudent(String studentName) {
        StudentAddEvent event = new StudentAddEvent(appContext, studentName);
        System.out.println(">>>publishEvent");
        appContext.publishEvent(event);
    }
}
