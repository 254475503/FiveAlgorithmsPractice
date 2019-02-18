package com.sohu.yifanshi.DFSandBFS;

import com.sohu.yifanshi.dijkstraAlgorithm.ENode;

import java.util.*;

public class BFS {//图的广度遍历

    public static void main(String[] args) {
        Map<String,List<ENode>> graph =  ENode.initAMap();
        BFS(graph);

    }
    public static void BFS(Map<String, List<ENode>> graph)
    {
        Map<String,Boolean> mark = new HashMap<String,Boolean>();
        for(Map.Entry<String,List<ENode>> entry : graph.entrySet())
        {
            mark.put(entry.getKey(),false);
        }
        for(Map.Entry<String,List<ENode>> entry : graph.entrySet())
        {
            if(!mark.get(entry.getKey()))
            {
                System.out.println(entry.getKey());
                mark.put(entry.getKey(),true);
                BFS(graph,entry.getKey(),mark);
            }
        }
    }

    public static void BFS(Map<String,List<ENode>> graph, String startPoint,Map<String,Boolean> mark)
    {
        Queue<ENode> nodeQueue = new LinkedList<>();
        for(ENode eNode : graph.get(startPoint))
        {
            if(!mark.get(eNode.id))
            {
                mark.put(eNode.id,true);
                System.out.println(eNode.id);
            }
        }
    }

}
