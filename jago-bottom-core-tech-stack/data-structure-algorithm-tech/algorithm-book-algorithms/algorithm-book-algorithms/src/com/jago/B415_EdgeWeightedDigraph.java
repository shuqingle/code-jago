package com.jago;

import java.util.Iterator;

/**
 * 加权有向图
 */
public class B415_EdgeWeightedDigraph {
    private final int V;
    private int E;
    private Bag<B415_DirectedEdge> [] adj;

    public B415_EdgeWeightedDigraph(int V){
        this.V =  V;
        this.E = E;
        adj = new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<>();
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(B415_DirectedEdge e){
        adj[e.from()].add(e);
        E++;
    }


    public Iterable<B415_DirectedEdge> adj(int v){
        return adj[v];
    }

    public Iterable<B415_DirectedEdge> edges(){
        Bag<B415_DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < V; v++) {
            for (B415_DirectedEdge e : adj(v)){
                bag.add(e);
            }
        }
        return bag;
    }











    private class Bag<T> implements Iterable{
        public void add(T t){

        }
        @Override
        public Iterator iterator() {
            return null;
        }
    }
}
