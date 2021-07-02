package com.xiaopantx.design.composite;

import sun.java2d.pipe.SpanIterator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author panxj
 */
public class MainTest {

    public static void main(String[] args) {
        Node root = new BranchNode("/", "根目录",
                Arrays.asList(
                        new BranchNode("/etc", "配置文件目录",
                                Arrays.asList(
                                        new Leaf("/etc/profile", "系统环境配置文件"),
                                        new BranchNode("/etc/sysconfig", "系统配置目录", Collections.emptyList()))),
                        new BranchNode("/proc", "操作系统映射目录", Collections.emptyList()),
                        new BranchNode("/root", "系统用户根目录", Collections.emptyList())));

        tree(root,  0);

    }

    public static void tree(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("\t");
        }
        node.print();
        if (node instanceof BranchNode) { // 递归结束条件
            BranchNode branch = (BranchNode) node;
            List<Node> nodes = branch.getNodes();
            depth++;
            for (Node n : nodes) { // 递归体
                tree(n, depth);
            }
        }
    }
}
