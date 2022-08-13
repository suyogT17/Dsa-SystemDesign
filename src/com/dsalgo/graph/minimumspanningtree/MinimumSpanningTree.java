package com.dsalgo.graph.minimumspanningtree;

import com.dsalgo.graph.undirectedgraphs.UndirectedAcyclicGraph;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
 * Theory: https://www.tutorialspoint.com/data_structures_algorithms/spanning_tree.htm
 */
public class MinimumSpanningTree {
    public static void main(String[] args) {
        int V = 5;
        UndirectedAcyclicGraph undirectedAcyclicGraph =  new UndirectedAcyclicGraph(V);
        int[][] edges = new int[][]{new int[]{0,1,2}, new int[]{1,2,3},new int[]{0,3,6},new int[]{1,3,8}, new int[]{1,4,5},new int[]{2,4,7}};
        undirectedAcyclicGraph.createGraph(edges);

        int ansBruteForce = Prims.primsAlgoBruteForce(V, undirectedAcyclicGraph.adjList);
        System.out.println("Prim's BruteForce: "+ansBruteForce);

        int ansOptimized = Prims.primsAlgoOptimized(V, undirectedAcyclicGraph.adjList);
        System.out.println("Prim's Optimized: "+ansOptimized);

        int ansKruskals = Kruskals.KruskalsAlgo(V, edges);
        System.out.println("Kruskal's Algo: "+ansKruskals);

    }
}
