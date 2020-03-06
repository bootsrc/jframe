package com.bootsrc.aop.controller;

import com.bootsrc.aop.core.Passport;
import com.bootsrc.aop.core.Resp;
import com.bootsrc.aop.consts.GlobalConst;
import com.bootsrc.aop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public Resp test() {
        Passport passport=new Passport();
        passport.setUserId(GlobalConst.DEFAULT_USER_ID);
        passport.setToken(GlobalConst.DEFAULT_TOKEN);
        return demoService.action0(passport, "666");
    }

    @RequestMapping("/test1")
    public Resp test1() {
        Passport passport=new Passport();
        passport.setUserId(101);
        passport.setToken("aaaaaa");
        return demoService.action0(passport, "777");
    }
}
