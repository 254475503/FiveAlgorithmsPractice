package com.sohu.yifanshi.DFSandBFS;

import com.sohu.yifanshi.dijkstraAlgorithm.ENode;

import java.util.*;

public class BFS {//图的广度遍历

    public static void main(String[] args) {
        Map<String,List<ENode>> graph =  ENode.initAMap();
        BFSSearch(graph,"0","5");
        BFS(graph);

    }
    public static void BFSSearch(Map<String,List<ENode>> graph,String startId,String targetId)
    {
        Queue<String> queue = new LinkedList<>();
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(startId,true);
        Map<String,String> prev = new HashMap<>();
        queue.add(startId);
        while (queue.size()!=0)
        {
            String id = queue.poll();
            List<ENode> eNodes = graph.get(id);
            for(int i = 0  ; i<eNodes.size();i++)
            {
                ENode node = eNodes.get(i);
                if(null==visited.get(node.id)||!visited.get(node.id))
                {
                    prev.put(node.id,id);
                    visited.put(node.id,true);
                    queue.add(node.id);
                }
                if(node.id .equals(targetId) )
                {
                    recurPrint(prev,startId,node.id);
                    return;
                }
            }
        }

    }

    public static void recurPrint(Map<String,String> prevMap,String startid,String targetId)
    {
        if(null!=prevMap.get(targetId)&&!targetId.equals(startid))
            recurPrint(prevMap,startid,prevMap.get(targetId));
        System.out.println(targetId+" ");
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
