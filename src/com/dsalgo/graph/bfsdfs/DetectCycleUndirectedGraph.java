package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * Code to detect cycle in undirected graph using BFS (Recursion, Iteration) and DFS (Recursion)
 * Approach:
 * -Time = O(V+E) Space=O(n)(for queue) (V = Vertex, E = Edges)
 * - DFS
 *   - Pass parent node along with the current node we are going to visit in the graph
 *   - if there is any node which is already visited but not parent then its cycle.
 * -BFS:
 *   - Maintain queue of Pair<curr,prev>
 *   - While adding child nodes to queue check if there is any node which is already visited but not prev then its cycle.
 */

public class DetectCycleUndirectedGraph {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        //done this as graph is disconnected
        //Call for BFS
        for(int i=0;i<V;i++){
            if(!visited[i]) {
                if(detectCycleDfs(i, -1, adj, visited)) return true;
            }
        }

        //Call for DFS
        for(int i=0;i<V;i++){
            if(!visited[i]) {
                visited[i] = true;
                Queue<Pair> queue= new LinkedList();
                queue.add(new Pair(i, -1));
                if(detectCycleBfsRec(adj, visited, queue)) return true;
            }
        }
        return false;
    }

    private boolean detectCycleDfs(int node, int prev, ArrayList<ArrayList<Integer>> adj, boolean[] visited){

        visited[node] = true;
        for(int i: adj.get(node)){
            if(!visited[i]){
                if(detectCycleDfs(i, node, adj, visited)){
                    return true;
                }
            }
            else if(i != prev) return true;
        }
        return false;
    }

    private boolean detetctCycleBfs( ArrayList<ArrayList<Integer>> adj, boolean[] visited, Queue<Pair> queue){

        while(!queue.isEmpty()){
            Pair curr = queue.poll();

            for(int i: adj.get(curr.node)){
                if(!visited[i]){
                    visited[i] =  true;
                    queue.offer(new Pair(i, curr.node));
                }
                else if(i != curr.prev) return true;
            }
        }
        return false;
    }

    private boolean detectCycleBfsRec( ArrayList<ArrayList<Integer>> adj, boolean[] visited, Queue<Pair> queue){
        if(queue.isEmpty()) return false;
        Pair curr =  queue.poll();
        for(int i: adj.get(curr.node)){
            if(!visited[i]){
                visited[i] = true;
                queue.add(new Pair(i, curr.node));
            }
            else if(i != curr.prev) return true;
        }
        return detectCycleBfsRec(adj, visited, queue);

    }
}

class Pair{
    int node , prev;
    public Pair(int node , int prev){
        this.node =  node;
        this.prev = prev;
    }
}