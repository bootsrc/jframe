package com.bootsrc.spring.event;

import org.springframework.context.ApplicationEvent;

public class StudentAddEvent extends ApplicationEvent {
    private String studentName;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public StudentAddEvent(Object source, String studentName) {
        super(source);
        this.studentName = studentName;
    }

    public String getStudentName(){
        return studentName;
    }
}
