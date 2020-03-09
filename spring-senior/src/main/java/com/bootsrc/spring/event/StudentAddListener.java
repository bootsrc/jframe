package com.bootsrc.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class StudentAddListener implements ApplicationListener {


    public void onApplicationEvent(ApplicationEvent event) {
        if (! (event instanceof StudentAddEvent)) {
            return;
        }

        StudentAddEvent studentAddEvent = (StudentAddEvent) event;
        System.out.println("onApplicationEvent() handle,studentName=" + studentAddEvent.getStudentName());
    }
}
