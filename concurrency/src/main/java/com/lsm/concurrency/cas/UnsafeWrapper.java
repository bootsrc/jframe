package com.lsm.concurrency.cas;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 在JDK8及以下，在用户自己的程序中无法执行Unsafe.getUnsafe()，报错
 * <code>java.lang.SecurityException: Unsafe
 * 	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90) ~[na:1.8.0_201]</code>
 *
 * 	所以，自己在封装来一个UnsafeWrapper来，通过反射获取JDK里面已经初始化好来的那个Unsafe对象.
 */
public class UnsafeWrapper {
    private static Class unsafeClass;
    private static Unsafe unsafeInstance;

    private UnsafeWrapper() {
        //no instance
    }

    private static void init() {
        try {
            unsafeClass = Class.forName("sun.misc.Unsafe");
            Field theUnsafeField = unsafeClass.getDeclaredField("theUnsafe");
            boolean orignialAccessible = theUnsafeField.isAccessible();
            theUnsafeField.setAccessible(true);
            Object obj = theUnsafeField.get(null);

            unsafeInstance = obj instanceof Unsafe ? (Unsafe) obj : null;
            theUnsafeField.setAccessible(orignialAccessible);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Unsafe unsafeInstance() {
        if(unsafeInstance == null) init();
        return unsafeInstance;
    }

    public static Class unsafeClass() {
        if(unsafeClass == null) init();
        return unsafeClass;
    }

}
