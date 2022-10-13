package com.dsalgo.graph.bfsdfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/bipartite-graph/1
 * A graph that can be coloured using 2 colours such that no two adjacent nodes have same colour
 * Key observations:
 * - if graph has odd length cycle then it can not be bipartite
 *
 * Approach
 * -BFS & DFS: Time = O(V+E)
 *  -if already visited adjacent node's color is similar to current node the return false
 */
class BipartiteGraph
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int[] colour = new int[V];
        Arrays.fill(colour, -1);
        Queue<Integer> queue =  new LinkedList();
        //BFS call
        for(int i = 0;i<V;i++){
            if(colour[i] == -1){
                queue.add(i);
                colour[i] = 0;
                if(checkBipartiteBfs(adj, queue, colour)==false) return false;
            }
        }
        //Dfs Call
        for(int i = 0;i<V;i++){
            if(colour[i] == -1){
                if(!checkBipartiteDfs(adj, i, 0, colour)) return false;
            }
        }
        return true;
    }

    private boolean checkBipartiteDfs(ArrayList<ArrayList<Integer>> adj, int node, int nextcolour, int[] colour){
        colour[node] = nextcolour;
        for(int i: adj.get(node)){
            if(colour[i] != -1){
                if(colour[i] == nextcolour){ //if any of the already visited adjacent has same color as the current nodes color then it's not bipartite graph
                    return false;
                }
            }
            else {
                if(!checkBipartiteDfs(adj, i, (nextcolour == 0)?1:0, colour)) return false;
            }
        }
        return true;
    }

    private boolean checkBipartiteBfs(ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue, int[] colour){
        while(!queue.isEmpty()){
            int curr =  queue.poll();
            for(int i: adj.get(curr)){
                if(colour[i] != -1){
                    if(colour[i] == colour[curr]){
                        return false;
                    }
                }
                else{
                    colour[i] = (colour[curr] == 0)?1:0;
                    queue.add(i);
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteBfsRecur(ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue, int[] colour){
        if(queue.isEmpty()) return true;
        while(!queue.isEmpty()){
            int curr =  queue.poll();
            for(int i: adj.get(curr)){
                if(colour[i] != -1){
                    if(colour[i] == colour[curr]){
                        return false;
                    }
                }
                else{
                    colour[i] = (colour[curr] == 0)?1:0;
                    queue.add(i);
                }
            }
        }
        return checkBipartiteBfsRecur(adj, queue, colour);
    }
}