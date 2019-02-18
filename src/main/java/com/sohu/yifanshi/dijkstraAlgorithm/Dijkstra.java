package com.sohu.yifanshi.dijkstraAlgorithm;

import java.util.*;

public class Dijkstra {
    //迪杰斯特拉算法
    //配合我的幕布食用效果更佳。
    //迪杰斯特拉算法是用来找有向图的最短路径的算法。大概的算法过程是，选取一个起始点，找到这个起始点的所有直接可达点，然后选取其中距离最短的可达点，
    //保存这个最短可达点及路径。然后再以这个最短可达点为起始点，开始新一轮的寻找。直到这个起始点，找到了图上最后一个尚未当作起始点的那个点，这样我们
    //记录下来的所有路径都是最短路径。也就达到了我们的目的。这是贪心算法的一种。其中这个算法最核心的操作就是，找到起始点的最近直接可达点。
    //结合代码说，核心操作就是松弛操作。松弛操作再下面有。
    public static void main(String[] args) {

        DijstraAlgorithms(ENode.initAMap(),"5");



    }
    public static void DijstraAlgorithms(Map<String, List<ENode>> graph,String startPoint)//graph 为图的邻接表，左边为图的定点，右边的list为以此顶点
            //为起点的边节点。
    {
        Map<String,Integer> dis = new HashMap<>();//以startPoint为起点，各个顶点为终点的最短路径图。左边为顶点，右边为距离。初始化此图时，起始点
        //直接可达的点直接赋值，不可直接到达的点，初始最小值为一个很大的值。
        Map<String,String> path = new HashMap<>();//path表示以指定节点为终点的最短路径的上一个节点的图。key为指定终点，value为最短路径的上一个节点(前驱节点)
        //path存在的意义就是为了记录起始点到指定终点的最短路径。我们可以从终点一步一步往前推，推到起点。
        Map<String,Boolean> mark = new HashMap<>();//对应的表示map dis中的节点是否已经找出其最小值，true为已经找出最小值，false为尚未找出
        String k = startPoint;

        for(String id : graph.keySet())//初始化dis，将起始点的最小值置为maxvalue
        {
            dis.put(id,Integer.MAX_VALUE);
            path.put(id,null);//起始点没有前驱节点
            mark.put(id,false);
        }
        for(ENode edge : graph.get(startPoint))//初始化dis的第二步，将以起始点为出发点直接可达的边节点放入dis中。
        {
            dis.put(edge.id,edge.weight);
            path.put(edge.id,startPoint);//此时这些起始点可达的边节点的前驱节点就是起始点。

        }
        mark.put(k,true);
        int n = graph.keySet().size();

        for(int i = 1 ; i <=n-2; i++)
        {
            k = selectKfromDis(dis,mark);//选出距离起始点最短且尚未松弛的点。

            for(ENode edge : graph.get(k))//松弛操作就是，将这个点的直接可达点全部遍历一遍，将这个点到这个点的直接可达点的距离+起始点到这个点的
                // 距离与起始点到这个点直接可达点的距离进行比较，若前者小，则将起始点到直接可达点的最短距离更新为前者值，反之不更新。
                //这里的这个点代表上面选出的距离起始点最短且尚未松弛的点。反映在代码中就是dis中最小，且对应的mark为false的点。每个点的直接可达点
                //都记录在graph中。
            {
                if ( !mark.get(edge.id) && dis.get(k)/*起始点到这个点的距离*/+edge.weight/*这个点到其直接可达点的距离*/ < dis.get(edge.id)/*起始点
                到这个点的直接可达点的距离*/ ) {//如果前者小，则更新起始点到这个点的直接可达点的距离，即dis中对应的值。
                    dis.put( edge.id, dis.get(k)+edge.weight );
                    path.put( edge.id, k );//更新最短路径。
                }

            }
            mark.put(k,true);//将选出的点置为已经松弛
        }
        for(Map.Entry<String,Integer> entry : dis.entrySet())
        {
            System.out.println(entry.getKey()+"-------------"+entry.getValue());
        }
        for(Map.Entry<String,String> entry : path.entrySet())
        {
            System.out.println(entry.getKey()+"-------------"+entry.getValue());
        }
    }

    public static String selectKfromDis(Map<String,Integer> dis,Map<String,Boolean> mark)
    {//从dis中选取一个已经初始化入dis中，且还未进行寻找最小值的节点。
        int min = Integer.MAX_VALUE;
        String id = null;
        for(Map.Entry<String,Integer> entry : dis.entrySet())
        {
            Boolean isSelected = !mark.get(entry.getKey());

            Boolean isLittle = entry.getValue()<min;

            if( !mark.get(entry.getKey()) && entry.getValue()<min)
            {
                min = entry.getValue();
                id = entry.getKey();
            }
        }
        return id;

    }
}
