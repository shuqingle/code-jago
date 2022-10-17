package com.jago;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 最短路径：Dijkstrap算法
 */
public class B403_DijkstraSP {
    private B415_DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public B403_DijkstraSP(B415_EdgeWeightedDigraph G, int s){
        edgeTo = new B415_DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
            distTo[s] = 0;
            pq.insert(s,0.0);
            while (!pq.isEmpty()){
                relax(G,(Integer) pq.remove());
            }
        }
    }

    private void relax(B415_EdgeWeightedDigraph G, int v) {
        for (B415_DirectedEdge e : G.adj(v)){
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()){
                //调整更新距离为最小
                distTo[w] = distTo[v] + e.weight();
                //上级边
                edgeTo[w] = e;
                if (pq.contains(w)){
                    //更新调整排序？
                    pq.change(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }
        }
    }


    private class IndexMinPQ<T> extends PriorityQueue{

        public void insert(int s,double value){
            Map map = new TreeMap();
            map.put(value,s);
            super.add(map);
        }

        public void change(int s,double value){
            Map map = new TreeMap();
            map.put(value,s);
            super.add(map);
        }
    }
}
