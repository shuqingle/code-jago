package com.jago;

import java.util.Iterator;

public class AT153_DigGraph {
    private final int V;
    private int E;
    private Bag<Integer> [] adj;
    public AT153_DigGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }


    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public AT153_DigGraph reverse(){
        AT153_DigGraph R = new AT153_DigGraph(V);
        for (int v = 0; v < V; v++) {
            for(int w  : adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }












    private class Bag<T> implements Iterable<T>{
        void add(T t){

        };

        @Override
        public Iterator<T> iterator() {
            return null;
        }
    }
}
