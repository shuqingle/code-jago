package com.jago;

/**
 * 加权有向边
 */
public class B415_DirectedEdge {
    private final int v;
    private final int w;
    private final double weight;


    public B415_DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    @Override
    public String toString() {
        return "B415_DirectedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
