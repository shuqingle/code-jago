package com.jago;

/**
 * 任意顶点对最短路径
 */
public class B424_DijkstraAllPairsSP {
    private B423_DijkstraSP [] all;
    B424_DijkstraAllPairsSP(B415_EdgeWeightedDigraph G){
        all = new B423_DijkstraSP[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v]= new B423_DijkstraSP(G,v);
        }
    }
}
