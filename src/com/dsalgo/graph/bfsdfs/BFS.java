package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 * Breadth first search implementation using recursive and iterative approach
 * Time = O(V+E) Space=O(n+n)(for queue and visited) (V = Vertex, E = Edges)
 */
public class BFS {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> output=  new ArrayList();
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited[0] = true;

        bfs(adj, visited, output, queue);
        return output;

        //iterative BFS call
        //return iterativeBfs(V,adj);
    }

    private void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited,  ArrayList<Integer> output, Queue<Integer> queue){
        if(queue.isEmpty()) return;
        int curr = queue.poll();
        output.add(curr);
        for(int i: adj.get(curr)){
            if(!visited[i]) {
                visited[i] = true;
                queue.add(i);
            }
        }
        bfs(adj, visited,output,queue);
    }

    private  ArrayList<Integer> iterativeBfs(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> output = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visited[0] = true;
        output.add(0);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            for(int i: adj.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    output.add(i);
                }
            }
        }
        return output;
    }
}
