package com.dsalgo.graph.undirectedgraphs;

public class Pair {
    public int node, distance;

    public Pair(int node, int distance) {
        this.distance = distance;
        this.node = node;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "node=" + node +
                ", distance=" + distance +
                '}';
    }
}
