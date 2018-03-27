package com.example.huanpet.utils;

/**
 * Created by 本丶小丝 on 2018/3/23.
 */

public class Screen {
    private int width;
    private int height;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getDir(boolean portrait) {
// landscape是横向，portrait是纵向
        if (portrait) {
            return String.format("values-%dx%d", height, width);
        } else {
            return String.format("values-land-%dx%d", height, width);
        }
    }

    @Override
    public String toString() {
        return "Screen [width=" + width + ", height=" + height + "]";
    }
}
