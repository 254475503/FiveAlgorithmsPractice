package com.sohu.yifanshi.DFSandBFS;

import com.sohu.yifanshi.dijkstraAlgorithm.ENode;

import java.util.*;

public class DFS {//图的深度遍历
    public static void main(String[] args) {
        DFS(ENode.initAMap());
    }
    public static void DFS(Map<String, List<ENode>> graph)
    {

        Map<String,Boolean> mark = new HashMap<String,Boolean>();
        for(Map.Entry<String,List<ENode>> entry : graph.entrySet()) {
            mark.put(entry.getKey(), false);
        }
        for(Map.Entry<String,List<ENode>> entry : graph.entrySet())
        {
            if(!mark.get(entry.getKey()))
            {
                System.out.println(entry.getKey());
                mark.put(entry.getKey(),true);
                DFS(graph,mark,entry.getKey());
            }
        }
    }

    public static void DFS(Map<String,List<ENode>> graph, Map<String,Boolean> mark, String startPoint)
    {
        for(ENode eNode : graph.get(startPoint))
        {
            if(!mark.get(eNode.id))
            {
                System.out.println(eNode.id);
                mark.put(eNode.id,true);
                DFS(graph,mark,eNode.id);
            }
        }
    }

}
