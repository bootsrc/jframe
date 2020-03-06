package com.bootsrc.jvm.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("")
public class HomeController implements ApplicationRunner {

    @RequestMapping("")
    public String index() {
        return "JvmDemo works!";
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("thread is running, time=" + new Date());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }
}
