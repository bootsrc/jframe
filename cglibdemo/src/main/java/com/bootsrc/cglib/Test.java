package com.bootsrc.cglib;

import com.bootsrc.cglib.service.DemoService;
import org.springframework.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(DemoService.class);
        enhancer.setCallback(new MyMethodInterceptor());
        DemoService demoService = (DemoService) enhancer.create();

        String ret = demoService.action0("abcd");
        System.out.println("ret=" + ret);
    }
}
