package com.jago;

import java.util.Scanner;

/**
 * 优先级限制下的并行任务调度问题的关键路径方法
 */
public class B431_CPM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        B415_EdgeWeightedDigraph G;
        G = new B415_EdgeWeightedDigraph(2*N+2);
        int s = 2*N;
        int t = 2*N+1;
        for (int i = 0; i < N; i++) {
            String[] a = sc.nextLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            G.addEdge(new B415_DirectedEdge(i,i+N,duration));
            G.addEdge(new B415_DirectedEdge(s,i,0.0));
            G.addEdge(new B415_DirectedEdge(i+N,t,0.0));
            for (int j = 0; j < a.length; j++) {
                int successor = Integer.parseInt(a[j]);
                G.addEdge(new B415_DirectedEdge(i+N,successor,0.0));
            }
        }
        B427_AcyclicSP lp = new B427_AcyclicSP(G,s);
        System.out.println("Start times:");
        for (int i = 0; i < N; i++) {
//            System.out.println(lp.distTo(i));
        }
//        System.out.println("Finish time："+lp.distTo(t));
    }
}
