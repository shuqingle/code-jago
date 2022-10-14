package com.jago;

import java.util.PriorityQueue;

public class B403_PrimMST {
    private B394_Edge [] edgeTo;
    private int[] distTo;
    private boolean[] marked;
    private PriorityQueue<Integer> pq;

    public B403_PrimMST(B395_EdgeWeightedGraph G){
        edgeTo = new B394_Edge[G.V()];
        distTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Integer.MIN_VALUE;
        }
        pq = new PriorityQueue<Integer>(G.V());

        distTo[0] =0;
        pq.add(0);
        while (!pq.isEmpty()){
            visit(G,pq.remove());
        }
    }

    private void visit(B395_EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (B394_Edge e : G.adj(v)){
            int w = e.either();
            if (marked[w]) continue;
            if (e.weight() < distTo[w]){
                edgeTo[w] = e;
                distTo[w] = Double.valueOf(e.weight()).intValue();
                if (pq.contains(w)){
//                    pq.change(w,distTo[w]);
//                    pq.add(w,distTo[w]);
                }
            }
        }
    }
}
