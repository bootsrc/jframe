package com.lsm.concurrency.controller;

import com.lsm.concurrency.cas.CasDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class HomeController {

    @RequestMapping("")
    public String index() {
        return "Concurrency works!";
    }

    @RequestMapping("cas")
    public String cas() {
        CasDemo casDemo= new CasDemo();
        String result = casDemo.action();
        return "cas result=" + result;
    }
}
