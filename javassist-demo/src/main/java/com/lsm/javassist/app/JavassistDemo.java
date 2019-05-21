package com.lsm.javassist.app;

import com.lsm.javassist.model.Point;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * javassist usage demo
 * javassist使用样例
 */
public class JavassistDemo {
    private static final String CLASS_NAME ="com.lsm.javassist.model.Point";

    public static void main(String[] args) throws Exception {
        insert();
        System.out.println(">>>writeFile() Done>>>");

        testPoint();
        System.out.println("======Done===");
    }

    private static void insert() throws Exception{
        // 对已有代码每次move执行时做埋点

        ClassPool pool = ClassPool.getDefault();

        CtClass cc = pool.get(CLASS_NAME);
        CtMethod m = cc.getDeclaredMethod("move");
        // 在方法执行前面插入"埋点"
        m.insertBefore("{ System.out.println(\"dx=\" + $1); System.out.println(\"dy=\" + $2); }");
        cc.stopPruning(true);
        cc.writeFile();
    }

    /**
     * 测试埋点是否起作用
     * @throws Exception
     */
    private static void testPoint() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get(CLASS_NAME);
        Class clazz = cc.toClass();
        Point point = (Point)clazz.newInstance();
        point.move(5, 18);
    }
}
