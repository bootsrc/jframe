package com.bootsrc.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

import javax.annotation.PostConstruct;

public class Foo implements InitializingBean, CommandLineRunner, ApplicationRunner {
    public Foo() {
        System.out.println("exe Constructor ...");
    }

    public void init() {
        System.out.println("exe init-method ...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("exe PostConstruct ...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("exe afterPropertiesSet ...");
    }

    @My("abc")
    public void myConfig(String conf) {
        System.out.println("myConfig() is invoked!  >>>conf=" + conf);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("exe CommandLineRunner ...");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("exe ApplicationRunner ...");
    }
}
