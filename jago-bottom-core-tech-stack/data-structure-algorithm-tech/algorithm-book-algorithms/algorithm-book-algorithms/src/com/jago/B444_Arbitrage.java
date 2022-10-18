package com.jago;

import java.util.Scanner;

/**
 * 货币兑换中的套汇
 */
public class B444_Arbitrage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        String [] name = new String[V];
        B415_EdgeWeightedDigraph G = new B415_EdgeWeightedDigraph(V);
        for (int v = 0; v < V; v++) {
            name[v] = sc.nextLine();
            for (int w = 0; w < V; w++) {
                double rate = sc.nextDouble();
                B415_DirectedEdge e = new B415_DirectedEdge(v,w,-Math.log(rate));
                G.addEdge(e);
            }
        }

        B438_Bellman_Ford spt = new B438_Bellman_Ford(G,0);
        if (spt.hasNegativeCycle()){
            double stake = 1000.0;
            for (B415_DirectedEdge e : spt.negativeCycle()){
                System.out.println(stake+":"+name[e.from()]);
                stake *= Math.exp(-e.weight());
                System.out.println(stake+":"+name[e.to()]);
            }
        }else {
            System.out.println("No arbitrage opprotunity");
        }
    }
}
