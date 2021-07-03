package com.xiaopantx.design.composite;

import java.util.List;

/**
 * @author panxj
 */
public class BranchNode extends Node {

    private List<Node> nodes;
    private String name;

    public BranchNode() {}

    public BranchNode(String path, String name, List<Node> nodes) {
        super.setPath(path);
        this.name = name;
        this.nodes = nodes;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BranchNode{" +
                "nodes=" + nodes +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void print() {
        //System.out.println("目录： path = " + super.getPath() + " name = " + this.name + " nodes = " + nodes.toString());
        System.out.println(this.getPath());
    }
}
