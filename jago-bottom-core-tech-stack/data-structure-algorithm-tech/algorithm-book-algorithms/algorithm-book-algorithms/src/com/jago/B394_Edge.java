package com.jago;

/**
 * 边实体
 */
public class B394_Edge implements Comparable<B394_Edge> {
    private final int v;
    private final int w;
    private final double weight;

    public B394_Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }

    public int either(){
        return v;
    }

    public int other(int vertex){
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else throw new RuntimeException("Inconsistent edge");
    }

    @Override
    public int compareTo(B394_Edge that) {
        if (this.weight < that.weight) return -1;
        else if (this.weight > that.weight) return 1;
        else return 0;
    }

    public String toString(){
        return String.format("%d-%d %.2f",v,w,weight);
    }
}
