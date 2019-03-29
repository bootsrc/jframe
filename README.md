# jframe

## 前言
用Java自己去写框架，需要掌握那些技术？
这个项目中会展示很多核心技术给你。

框架常见有以下几种 ：
- spring-boot-starter

    springboot的spring factory开发，也叫springboot扩展点开发。使用的时候，可以被springboot的
    
    SpringFactoriesLoader处理,这里会执行starer中的代码，以完成我们的springboot扩展功能。

    开发已完成，点击进入[jframe-spring-boot-starter](jframe-spring-boot-starter)
    应用[jframe-app](jframe-app)

    比如spring官方的<code>spring-boot-starter-web, spring-boot-starter-redis</code>
    第三方的比如<code>mybatis-spring-boot-starter, druid-spring-boot-starter</code>

- ConnectionPool

    各种jdbc,redis等连接池的实现
    
    开发中...

    基于GenericObjectPool

- ThreadLocal

    开发中...

- 动态代理

    开发中... <br/>
    AOP的实现原理，基于InvocationHandler+Proxy，解答问题为什么Mybatis的dao接口不需要实现类.

## 分类说明
**自己写spring-boot-starter**

测试:比如我这里是<code>jframe-spring-boot-starter </code>

[http://localhost:29001/starter/x123](http://localhost:29001/starter/x123)

返回值:

```text
pppx123sss
```
说明starter运行成功。验证了自己的jar包jframe-spring-boot-starter运行成功.
