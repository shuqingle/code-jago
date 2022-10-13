package com.jago;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小生成树的Prim算法的延时实现
 */
public class B400_LazyPrimMST {
    private boolean[] marked;
    private Queue<B394_Edge> mst;
    private PriorityQueue<B394_Edge> pq;

    public B400_LazyPrimMST(B395_EdgeWeightedGraph G) {
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new ArrayDeque<>();
        visit(G,0);
        while (!pq.isEmpty()){
            B394_Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]){
                continue;
            }
            mst.add(e);
            if (!marked[v]){
                visit(G,v);
            }
            if (!marked[w]){
                visit(G,w);
            }
        }
    }

    private void visit(B395_EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for(B394_Edge e : G.adj(v)){
            if (!marked[e.other(v)]){
                pq.add(e);
            }
        }
    }

    public Iterable<B394_Edge> edges(){
        return mst;
    }


}
