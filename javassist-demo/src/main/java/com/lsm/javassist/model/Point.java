package com.lsm.javassist.model;

public class Point {
    private int x;
    private int y;

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
