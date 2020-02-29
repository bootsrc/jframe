package com.bootsrc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot bean BeanPostProcessor , InitializingBean方法的执行顺序
 */
@SpringBootApplication
public class SpringExeSeqApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringExeSeqApp.class, args);
    }
}
