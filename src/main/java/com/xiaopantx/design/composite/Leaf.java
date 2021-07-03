package com.xiaopantx.design.composite;

/**
 * @author panxj
 */
public class Leaf extends Node {

    private String conent;

    public Leaf() {

    }

    public Leaf(String path, String content) {
        super.setPath(path);
        this.conent = content;
    }


    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }

    @Override
    public void print() {
        //System.out.println("文件: path = " + super.getPath() + ", content = " + this.conent);
        System.out.println(this.getPath());
    }
}
