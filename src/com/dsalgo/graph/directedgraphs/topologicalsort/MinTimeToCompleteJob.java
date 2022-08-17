package com.dsalgo.graph.directedgraphs.topologicalsort;

import com.dsalgo.graph.directedgraphs.DirectedAcyclicGraph;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Problem Link: https://www.geeksforgeeks.org/minimum-time-taken-by-each-job-to-be-completed-given-by-a-directed-acyclic-graph/
 * used distance to reach node using topological sort +  bfs over topological sort
 */
public class MinTimeToCompleteJob {

    public static void main(String[] args) {
        int V = 10;
        DirectedAcyclicGraph directedAcyclicGraph =  new DirectedAcyclicGraph(V);
        int[][] edges = new int[][]{new int[]{0,2,1}, new int[]{0,3,1},new int[]{0,4,1},new int[]{1,2,1},new int[]{1,7,1}, new int[]{1,8,1}, new int[]{2,5,1},
                new int[]{3,5,1}, new int[]{3,7,1},new int[]{4,7,1},new int[]{5,6,1},new int[]{6,7,1}, new int[]{7,9,1}};
        directedAcyclicGraph.createGraph(edges);
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayList<Integer> topoSort = directedAcyclicGraph.generateTopologicalSort();
        for(int i=0;i<V;i++){
            if(distance[i] == Integer.MAX_VALUE)
                timeTaken(i,topoSort,directedAcyclicGraph.adjList,distance);

        }
        System.out.println(topoSort);
        System.out.println("distance: "+Arrays.toString(distance));

    }

    private static void timeTaken(int node, ArrayList<Integer> topoSort , ArrayList<ArrayList<Pair>> adj, int[] distance) {
        distance[node] = 1;
        for (int i : topoSort) {
            if(distance[i] != Integer.MAX_VALUE) {
                for (Pair ad : adj.get(i)) {
                    distance[ad.node] = distance[i] + 1;
                }
            }
        }
    }
}
