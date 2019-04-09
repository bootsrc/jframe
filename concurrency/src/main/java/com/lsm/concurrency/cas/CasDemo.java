package com.lsm.concurrency.cas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CasDemo {
    private static final Logger logger = LoggerFactory.getLogger(CasDemo.class);
    public String action(){
        MyCacheLong myCacheLong = new MyCacheLong(101);
        myCacheLong.getAndUpdate(199);
        myCacheLong.getAndUpdate(341);

        logger.info("---myCacheLong.get()={}", myCacheLong.get());
        return myCacheLong.get() + "";
    }
}
