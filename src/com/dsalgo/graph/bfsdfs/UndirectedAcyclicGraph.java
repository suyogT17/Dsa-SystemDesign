package com.dsalgo.graph.bfsdfs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementation of Undirected Acyclic Graph with weights
 */

public class UndirectedAcyclicGraph {

    public ArrayList<ArrayList<Pair>> adjList =  new ArrayList<ArrayList<Pair>>();
    private int V = 0;
    public UndirectedAcyclicGraph(int V){
        this.V = V;
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<Pair>());
        }
    }

    void addEdge(int from, int to, int weight){
        adjList.get(from).add(new Pair(to, weight));
        adjList.get(to).add(new Pair(from, weight));

    }

    public void createGraph(int[][] edges){
        for(int[] edge: edges){
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public void printGraph(){
        int i=0;
        for(ArrayList<Pair> adj: adjList){
            System.out.println(i +" -> "+ adj);
        }
    }
}