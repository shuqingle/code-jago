package com.jago;

import java.util.Iterator;

/**
 * 加权无向图
 */
public class B395_EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<B394_Edge>[] adj;
    public B395_EdgeWeightedGraph(int V){
        this.V = V;
        this.E = E;
        adj = (Bag<B394_Edge>[]) new Bag[V];
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

    public void addEdge(B394_Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    public Iterable<B394_Edge> adj(int v){
        return adj[v];
    }

    public Iterable<B394_Edge> edges(){
        Bag<B394_Edge> b = new Bag<>();
        for (int v = 1; v < V; v++) {
            for(B394_Edge e:adj(v)){
                if (e.other(v) > v){
                    b.add(e);
                }
            }
        }
        return b;
    }



    private class  Bag<T> implements Iterable{

        @Override
        public Iterator iterator() {
            return null;
        }

        public void add(T t){};

    }
}
