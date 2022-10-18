package com.jago;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 基于队列的Bellman_Ford 算法
 */
public class B438_Bellman_Ford {
    private double[] distTo;//从起点到某个顶点的路径长度
    private B415_DirectedEdge[] edgeTo;//从起到到某个顶点的最后一条边
    private boolean[] onQ;//该顶点是否存在于队列中
    private Queue<Integer> queue;//正在被放松的顶点
    private int cost;//relax的调用次数
    private Iterable<B415_DirectedEdge> cycle;//edgeTo[]中是否有负权重的环

    public B438_Bellman_Ford(B415_EdgeWeightedDigraph G,int s) {
        distTo = new double[G.V()];
        edgeTo = new B415_DirectedEdge[G.V()];
        onQ = new boolean[G.V()];
        queue = new ArrayBlockingQueue<>(10000);
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        queue.add(s);
        onQ[s] = true;
        while (!queue.isEmpty() && !hasNegativeCycle()){
            int v = queue.remove();
            onQ[v] = false;
            relax(G,v);
        }
    }



    public void relax(B415_EdgeWeightedDigraph G, int v){
        for (B415_DirectedEdge e:G.adj(v)){
            int w = e.to();
            if (distTo[w] > distTo[v]+e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (!onQ[w]){
                    queue.add(w);
                    onQ[w] = true;
                }
            }
            if (cost++ %G.V() == 0){
                findNegativeCycle();
            }
        }
    }

    public void findNegativeCycle() {
        int V = edgeTo.length;
        B415_EdgeWeightedDigraph spt;
        spt = new B415_EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            if (edgeTo[v] != null){
                spt.addEdge(edgeTo[v]);
            }
        }
        EdgeWeightedCycleFinder cf;
        cf = new EdgeWeightedCycleFinder(spt);
        cycle =  cf.cycle();

    }

    public class EdgeWeightedCycleFinder{

        public EdgeWeightedCycleFinder(B415_EdgeWeightedDigraph spt) {
        }

        public Iterable<B415_DirectedEdge> cycle() {
            return new ArrayList<B415_DirectedEdge>();
        }
    }

    public boolean hasNegativeCycle() {
       return cycle != null;
    }
    public Iterable<B415_DirectedEdge> negativeCycle() {
        return cycle;
    }
}
