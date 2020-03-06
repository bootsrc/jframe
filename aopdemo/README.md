# aopdemo
使用Spring AOP来进进行服务/执行方法的"权限认证"

```text
@Around这个注解有两大经典应用。
1.权限认证的拦截
    proceedingJoinPoint.getArgs()可以获取method的参数，可以对参数进行认证，来确定这个方法是否
    有权限执行。参数一般用自己的自定义的class，这样比较容易快速去匹配，一旦匹配上了Passport这个class
    说明是需要进行认证的. 再根据Passport#userId, Passport#token进行认证。
    如果认证通过就执行Object obj = proceedingJoinPoint.proceed(); return obj;

2.方法/服务的监控
    在proceedingJoinPoint.proceed()执行的前后，获取时间戳值，然后两值进行相减，得到方法执行的耗时。
    还可以对执行的次数进行累积。 耗时经过采集，可以得到最大值，平均值，请求频率等等。
3.自定义日志，或者日志的集中采集。  
    proceedingJoinPoint.getArgs()可以获取method的参数。 参数和请求的时间戳都是日志的重要数据。
    这样进行统一的日志采集，避免了跟业务代码的耦合。并且能够集中上传日志，适合大型系统的日志集中处理。
```
