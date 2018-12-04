package com.sohu.yifanshi.dijkstraAlgorithm;

public class ENode {//边节点，包含了有向图中的一条边，以及这条边指向的节点。
    public String id;
    public int weight;

    public ENode(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}
