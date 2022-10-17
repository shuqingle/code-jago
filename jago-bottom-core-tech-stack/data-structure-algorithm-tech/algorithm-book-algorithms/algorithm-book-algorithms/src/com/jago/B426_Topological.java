package com.jago;

public class B426_Topological {
    private Iterable<Integer> order;
    public B426_Topological(B415_EdgeWeightedDigraph G){
        B426_DirectedCycle cyclefinder = new B426_DirectedCycle(G);
        if (!cyclefinder.hasCycle()){
            B426_DepthFirstOrder dfs = new B426_DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean isDAG(){
        return order != null;
    }
}
