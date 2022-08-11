package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * Depth first search implementation using recursive and iterative approach
 * Time = O(V+E) Space=O(n+visited)(for stack and visited) (V = Vertex, E = Edges)
 */
public class DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean [] visited = new boolean[V];
        ArrayList<Integer> output =  new ArrayList();

        //Perform recursibve DFS call
        dfsRecursive(0, adj, visited, output);

        //Perform iterative DFS call
        dfsIterative(adj, visited, output);

        return output;
    }

    //performs right to left DFS traversal
    private void dfsIterative(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> output){
        Stack<Integer> stack =  new Stack();
        stack.push(0);
        while(!stack.isEmpty()){
            int curr =  stack.pop();
            visited[curr] =  true;

            output.add(curr);
            for(int i= adj.get(curr).size()-1;i>=0;i--){
                int x= adj.get(curr).get(i);
                if(!visited[x]){
                    stack.push(x);
                }
            }
        }
    }

    //performs left to right DFS traversal
    private void dfsRecursive(int node, ArrayList<ArrayList<Integer>> adj, boolean[]  visited, ArrayList<Integer> output){
        visited[node] = true;
        output.add(node);

        for(int i: adj.get(node)){
            if(!visited[i])
                dfsRecursive(i, adj, visited, output);
        }
    }
}