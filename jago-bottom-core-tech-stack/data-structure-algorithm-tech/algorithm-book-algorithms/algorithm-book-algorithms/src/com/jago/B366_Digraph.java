package com.jago;

import java.util.Iterator;

public class B366_Digraph {
    private final int V;
    private int E;
    private Bag<Integer> [] adj;

    public B366_Digraph(int V){
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

    public B366_Digraph reverse(){
        B366_Digraph R = new B366_Digraph(V);
        for (int v = 0; v < V; v++) {
            for(int w: adj(v)){
                R.addEdge(w,v);
            }
        }
        return R;
    }



    private class  Bag<T> implements Iterable{

        @Override
        public Iterator iterator() {
            return null;
        }

        public void add(T t){};

    }
}
