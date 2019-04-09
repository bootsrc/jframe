package com.lsm.concurrency.cas;

import sun.misc.Unsafe;

public class MyCacheLong {
    // setup to use Unsafe.compareAndSwapLong for updates

    // JDK8及以下，不能直接使用Unsafe.getUnsafe()
    // private static final Unsafe unsafe = Unsafe.getUnsafe();
    private static final Unsafe unsafe = UnsafeWrapper.unsafeInstance();

    private static long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(MyCacheLong.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private volatile long value;


    public MyCacheLong(long initialValue) {
        value = initialValue;
    }

    /**
     * Gets the current value.
     *
     * @return the current value
     */
    public final long get() {
        return value;
    }

    /**
     * Sets to the given value.
     *
     * @param newValue the new value
     */
    public final void set(long newValue) {
        value = newValue;
    }

    public final boolean compareAndSet(long expect, long update) {
        return unsafe.compareAndSwapLong(this, valueOffset, expect, update);
    }

    public final long getAndUpdate(long update) {
        long prev;
        do {
            prev = get();
        } while (!compareAndSet(prev, update));
        return prev;
    }
}
