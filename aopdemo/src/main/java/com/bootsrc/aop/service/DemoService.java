package com.bootsrc.aop.service;

import com.bootsrc.aop.core.Passport;
import com.bootsrc.aop.core.Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private Logger log = LoggerFactory.getLogger(getClass());

    public Resp action0(Passport passport, String input) {
        log.info("enter action0...");
        return Resp.success("action0 success. input=" + input);
    }
}
