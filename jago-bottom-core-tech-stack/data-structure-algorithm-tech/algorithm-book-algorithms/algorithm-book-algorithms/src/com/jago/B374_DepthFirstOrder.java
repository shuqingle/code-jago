package com.jago;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class B374_DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public B374_DepthFirstOrder(B366_Digraph G){
        pre = new ArrayDeque<>();
        post = new ArrayDeque<>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(B366_Digraph G, int v) {
        pre.add(v);
        marked[v] = true;
        for(int w:G.adj(v)){
            if (!marked[w]){
                dfs(G,w);
            }
        }
        post.add(v);
        reversePost.push(v);
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
