package com.dsalgo.graph.minimumspanningtree;

public class Tuple3 {
    int node1, node2, weight;
    public Tuple3(int node1, int node2, int weight){
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
    public String toString(){
        return node1 +" - "+ node2 +" - "+weight;
    }
}
