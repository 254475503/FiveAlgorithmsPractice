package com.sohu.yifanshi.dijkstraAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ENode {//边节点，包含了有向图中的一条边，以及这条边指向的节点。
    public String id;
    public int weight;

    public ENode(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }
    public static Map<String, List<ENode>> initAMap()
    {
        ENode Enode00 = new ENode("0",20);
        ENode Enode10 = new ENode("1",50);
        ENode Enode11 = new ENode("1",20);
        ENode Enode20 = new ENode("2",15);
        ENode Enode21 = new ENode("2",10);
        ENode Enode30 = new ENode("3",30);
        ENode Enode31 = new ENode("3",15);
        ENode Enode32 = new ENode("3",3);
        ENode Enode40 = new ENode("4",35);
        ENode Enode41 = new ENode("4",10);
        ENode Enode42 = new ENode("4",70);
        Map<String,List<ENode>> graph = new HashMap<String,List<ENode>>();
        ENode[] eNodes = new ENode[]{};
        List<ENode> enode0List = new ArrayList<>();
        enode0List.add(Enode21);
        enode0List.add(Enode10);
        enode0List.add(Enode42);
        List<ENode> enode1List = new ArrayList<>();
        enode1List.add(Enode41);
        enode1List.add(Enode20);
        List<ENode> enode2List = new ArrayList<>();
        enode2List.add(Enode00);
        enode2List.add(Enode31);
        List<ENode> enode3List = new ArrayList<>();
        enode3List.add(Enode11);
        enode3List.add(Enode40);
        List<ENode> enode4List = new ArrayList<>();
        enode4List.add(Enode30);
        List<ENode> enode5List = new ArrayList<>();
        enode5List.add(Enode32);
        graph.put("0",enode0List);
        graph.put("1",enode1List);
        graph.put("2",enode2List);
        graph.put("3",enode3List);
        graph.put("4",enode4List);
        graph.put("5",enode5List);
        return graph;
    }

}
