package com.jago;

public class B380_KosarajuSCC {
    private boolean[] marked;
    private int [] id;
    private int count;

    public B380_KosarajuSCC(B366_Digraph G) {
        this.marked = marked;
        id = new int[G.V()];
        B374_DepthFirstOrder order = new B374_DepthFirstOrder(G.reverse());
        for(int s : order.reversePost()){
            if (!marked[s]){
                dfs(G,s);
                count++;
            }
        }
    }

    private void dfs(B366_Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)){
            if (!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
