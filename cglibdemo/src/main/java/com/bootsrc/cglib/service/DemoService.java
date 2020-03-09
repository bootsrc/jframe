package com.bootsrc.cglib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    private Logger log = LoggerFactory.getLogger(getClass());

    public String action0(String input) {
        log.info("enter action0...");
        return "action0 success. input=" + input;
    }
}
