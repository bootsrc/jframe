package com.bootsrc.nio;

/**
 * @author ：Frank
 * @date ：Created in 2019/7/26 16:47
 * @description：
 * @modified By：
 */
public class Inc {
/*
    简写：
    i = i++;
    /////// 分解如下
    int temp = i;
    i =i+ 1;
    int i = temp;
*/

    public static void main(String[] args) {
        int i=0;

        i = i++;
        System.out.println(i);
    }
}
