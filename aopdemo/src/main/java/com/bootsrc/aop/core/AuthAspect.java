package com.bootsrc.aop.core;

import com.bootsrc.aop.consts.GlobalConst;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthAspect {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(* com.bootsrc.*.service..*.*(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before() {
        log.info(">>>before");
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) {
        log.info(">>>after");
//        System.out.println(joinPoint.getArgs());
    }

    /**
     * @Around这个注解有两大经典应用。
     *
     * 1.权限认证的拦截
     *     proceedingJoinPoint.getArgs()可以获取method的参数，可以对参数进行认证，来确定这个方法是否
     *     有权限执行。参数一般用自己的自定义的class，这样比较容易快速去匹配，一旦匹配上了Passport这个class
     *     说明是需要进行认证的. 再根据Passport#userId, Passport#token进行认证。
     *     如果认证通过就执行Object obj = proceedingJoinPoint.proceed(); return obj;
     *
     * 2.方法/服务的监控
     *     在proceedingJoinPoint.proceed()执行的前后，获取时间戳值，然后两值进行相减，得到方法执行的耗时。
     *     还可以对执行的次数进行累积。 耗时经过采集，可以得到最大值，平均值，请求频率等等。
     * 3.自定义日志，或者日志的集中采集。
     *     proceedingJoinPoint.getArgs()可以获取method的参数。 参数和请求的时间戳都是日志的重要数据。
     *     这样进行统一的日志采集，避免了跟业务代码的耦合。并且能够集中上传日志，适合大型系统的日志集中处理。
     *
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint)
            throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();
        Passport passport = new Passport();
        if (needAuth(args, passport)) {
            if (check(passport)) {
                log.info(">>>认证成功");
                Object obj = proceedingJoinPoint.proceed();
                log.info("auth_return()={}", obj);
                return obj;
            } else {
//                log.info("xxx-认证失败");
                Resp obj = Resp.fail(10000, "认证失败");
                log.info("XXX认证失败!!! auth return={}", obj);
                return obj;
            }
        }

        log.info("===不需要进行认证.");
        return proceedingJoinPoint.proceed();
    }

    private boolean needAuth(Object[] args, Passport passport) {
        if (args.length == 0) {
            return false;
        }
        for (Object arg : args) {
            if (Passport.class.equals(arg.getClass())) { // need Auth
                Passport tmp = (Passport) arg;
                passport.setUserId(tmp.getUserId());
                passport.setToken(tmp.getToken());
                return true;

            }
        }
        return false;
    }

    private boolean check(Passport passport) {
        if (passport != null) {
            return passport.getUserId() == GlobalConst.DEFAULT_USER_ID
                    && GlobalConst.DEFAULT_TOKEN.equals(passport.getToken());
        }
        return false;
    }
}
