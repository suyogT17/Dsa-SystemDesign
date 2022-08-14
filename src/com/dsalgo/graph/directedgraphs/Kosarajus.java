package com.dsalgo.graph.directedgraphs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
 * Implementation for Kosaraju's Algorithm
 * Time= O(V+E) Space= O(V+E)
 * Steps in algo:
 *  1. Find topological sort
 *  2. Generate Transpose of the graph (reverse the direction of edges)
 *  3. Perform DFS traversal on topological sort
 */

class Kosarajus
{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack =  new Stack();
        //Step 1: find topological Sort
        for(int i=0;i<V;i++){
            if(!visited[i])
                getTopoSort(i,adj, stack, visited);
        }

        //Step 2: transpose graph
        ArrayList<ArrayList<Integer>> adjTranspose =  new ArrayList();
        for(int i=0;i<V;i++){
            adjTranspose.add(new ArrayList<Integer>());
        }
        for(int i=0;i<V;i++){
            for(int el: adj.get(i)){
                adjTranspose.get(el).add(i);
            }
        }

        //Step 3: run DFS and get components
        int output  = 0;
        Arrays.fill(visited, false);
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                System.out.print(node);
                getComponents(node,adjTranspose, visited);
                System.out.println();
                output++;
            }
        }
        return output;
    }

    private void getTopoSort(int node,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited){
        visited[node] = true;

        for(int i: adj.get(node)){
            if(!visited[i]){
                getTopoSort(i, adj,stack,visited);
            }
        }
        stack.push(node);
    }

    private void getComponents(int node,ArrayList<ArrayList<Integer>> adjTranspose, boolean[] visited){
        visited[node] = true;
        for(int i: adjTranspose.get(node)){
            if(!visited[i]){
                getComponents(i, adjTranspose,visited);
                System.out.print(" - "+i);

            }
        }
    }
}
