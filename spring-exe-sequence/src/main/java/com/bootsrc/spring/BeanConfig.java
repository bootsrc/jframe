package com.bootsrc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "init")
    public Foo foo() {
        return new Foo();
    }
}
