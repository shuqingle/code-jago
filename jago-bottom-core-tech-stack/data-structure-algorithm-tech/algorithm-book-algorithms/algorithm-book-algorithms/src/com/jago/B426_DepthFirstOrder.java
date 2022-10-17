package com.jago;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class B426_DepthFirstOrder {
    private boolean [] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public B426_DepthFirstOrder(B415_EdgeWeightedDigraph G){
        pre  = new ArrayDeque<Integer>();
        post  = new ArrayDeque<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
//        for (int v = 0; v < G.V(); v++) {
//            if (!marked[v]){
//                dfs(G,v);
//            }
//        }
    }

    private void dfs(B415_EdgeWeightedDigraph G, B415_DirectedEdge v) {
//        pre.add(v);
//        marked[v] = true;
//        for (B415_DirectedEdge w : G.adj(v)){
//            if (!marked[w]){
//                dfs(G,w);
//            }
//        }
//        post.add(v);
//        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
