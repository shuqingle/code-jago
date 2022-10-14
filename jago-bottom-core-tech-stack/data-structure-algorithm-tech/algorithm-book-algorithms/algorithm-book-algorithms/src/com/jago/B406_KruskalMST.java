package com.jago;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class B406_KruskalMST {
    private Queue<B394_Edge> mst;
    public B406_KruskalMST(B395_EdgeWeightedGraph G){
        mst = new ArrayDeque<>();
        PriorityQueue<B394_Edge> pq = new PriorityQueue<>();
        for(B394_Edge e : G.edges()) pq.add(e);

    }
}
