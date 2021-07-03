package com.xiaopantx.design.composite;

/**
 * @author panxj
 */
public abstract class Node {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract void print();
}
