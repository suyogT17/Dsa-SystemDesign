package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * Code to detect cycle in directed graph using DFS (Recursion)
 * Approach:
 * -DFS
 *  -Time = O(V+E) Space=O(n+n)(for visited and dfsVisited array) (V = Vertex, E = Edges)
 *  - Maintain two visited arrays. visited and dfsVisited
 *  - As you visit nodes mark visited and dfsVisited both true
 *  - on finishing each path, if it doesn't have cycle, while travelling back mark nodes in dfsVisited as false
 * -BFS
 *  -Time = O(V+E) Space=O(n+n)(for queue and in-degree array) (V = Vertex, E = Edges)
 *  - Use Kahn's algorithm to generate topological sort.
 *  - If topological sort does not contain all the nodes it means cycle is present in the graph
 *  - Intuition behind this is topological sort does not work on Directed Cyclic Graphs
 */

public class DetectCycleDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[]  visited = new boolean[V];
        boolean[]  dfsVisited = new boolean[V];
        //for disconnected graph
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(detectCycleDfs(i, adj, visited, dfsVisited)) return true; //if cycle is present dont check for further nodes
            }
        }
        return false;
    }

    private boolean detectCycleDfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited){
        visited[node] =  true;
        dfsVisited[node] =  true;
        for(int i: adj.get(node)){
            if(!visited[i]){                    //dont visit nodes which are already visited
                if(detectCycleDfs(i, adj, visited,dfsVisited)){
                    return true;
                }
            }
            else if(dfsVisited[i]) {
                return true;
            }
        }
        dfsVisited[node] =  false;
        return false;
    }
}