package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem link: https://leetcode.com/problems/critical-connections-in-a-network/
 * Implementation of finding bridges in graph using DFS.
 * - Finding those edges in the graph whose removal will break the graph into two or more components
 * Approach
 * - DFS : Time: O(V+E)
 * - maintain two arrays low time and insertion time
 * - use timer starting from 0 and at each node it will increase by 1
 * - visit node and mark it as visited and set its low and insertion as timer
 * - visit adjacent nodes of node
 *      - if adjacent is parent then skip that as current's low will be always greater than parent
 *      - else
 *          - if adjacent is not visited then
 *             - run dfs on that
 *             - after getting back from dfs call
 *             - set low of node to min of (current low or adjacent low)
 *             - if low of adjacent is greater than insertion of current,
 *               this means node has only one path to reach adjacent so its low is greater than parent and that's bridge
 *          - else adjacent is visited so set low of current node to min of (low of current, insertion of adjacent)
 */
class BridgeInGraph {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited =  new boolean[n];
        int[] low =  new int[n];
        int[] insertion =  new int[n];
        List<List<Integer>> output =  new ArrayList();

        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(List<Integer> connection: connections){
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        int timer = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(0, -1, visited, insertion, low, graph, timer,output);
            }
        }
        return output;
    }

    void dfs(int node, int parent, boolean[] visited, int[] insertion, int[] low, List<List<Integer>> graph,int timer, List<List<Integer>> output){
        visited[node] =  true;
        insertion[node] = low[node] = timer++;

        for(int ad: graph.get(node)){

            if(ad == parent ||  node == ad) continue; // if adjacent is parent then ignore

            if(!visited[ad]){
                dfs(ad, node, visited, insertion, low, graph, timer,output);
                low[node] = Math.min(low[node], low[ad]); //set low = current low or adjacent's low

                if(low[ad] > insertion[node]){ // this means node has only one path to visit adjacent so its low is greater than parent
                    output.add(new ArrayList<Integer>(Arrays.asList(node, ad)));
                }
            }
            else{
                low[node] = Math.min(low[node], insertion[ad]); //if node is already visited then check adj is inserted early by any other path or not if yes then made low equal to that path
            }
        }
    }
}