package com.sohu.yifanshi.dijkstraAlgorithm;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
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
        DijstraAlgorithms(graph,"5");



    }
    public static void DijstraAlgorithms(Map<String, List<ENode>> graph,String startPoint)//graph 为图的邻接表，左边为图的定点，右边的list为以此顶点
            //为起点的边节点。
    {
        Map<String,Integer> dis = new HashMap<>();//以startPoint为起点，各个顶点为终点的最短路径图。左边为顶点，右边为距离。初始化此图时，起始点
        //直接可达的点直接赋值，不可直接到达的点，初始最小值为一个很大的值。
        Map<String,String> path = new HashMap<>();//
        Map<String,Boolean> mark = new HashMap<>();
        String k = startPoint;

        for(String id : graph.keySet())
        {
            dis.put(id,Integer.MAX_VALUE);
            path.put(id,null);
            mark.put(id,false);
        }
        for(ENode edge : graph.get(startPoint))
        {
            dis.put(edge.id,edge.weight);
            path.put(edge.id,startPoint);

        }
        mark.put(k,true);
        int n = graph.keySet().size();

        for(int i = 1 ; i <=n-2; i++)
        {
            k = selectKfromDis(dis,mark);
            mark.put(k,true);
            for(ENode edge : graph.get(k))
            {
                if ( !mark.get(edge.id) && dis.get(k)+edge.weight < dis.get(edge.id) ) {
                    dis.put( edge.id, dis.get(k)+edge.weight );
                    path.put( edge.id, k );
                }

            }
        }
        for(Map.Entry<String,Integer> entry : dis.entrySet())
        {
            System.out.println(entry.getKey()+"-------------"+entry.getValue());
        }
    }

    public static String selectKfromDis(Map<String,Integer> dis,Map<String,Boolean> mark)
    {//从dis中选取一个还未进行
        int min = Integer.MAX_VALUE;
        String id = null;
        for(Map.Entry<String,Integer> entry : dis.entrySet())
        {
            Boolean isSelected = !mark.get(entry.getKey());

            Boolean isLittle = entry.getValue()<min;

            if( isSelected && isLittle)
            {
                min = entry.getValue();
                id = entry.getKey();
            }
        }
        return id;

    }
}
