package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem link: https://leetcode.com/problems/critical-connections-in-a-network/
 * Implementation of Articulation Point in graph using DFS.
 * - Finding those nodes in the graph whose removal will break the graph into two or more components
 * Approach
 * - DFS : Time: O(V+E)
 * - maintain three arrays low time, insertion time, articulation
 * - use timer starting from 0 and at each node it will increase by 1
 * - visit node and mark it as visited and set its low and insertion as timer
 * - visit adjacent nodes of node
 *      - if adjacent is parent then skip that as current's low will be always greater than parent
 *      - else
 *          - if adjacent is not visited then
 *             - run dfs on that
 *             - after getting back from dfs call
 *             - set low of node to min of (current low or adjacent low)
 *             - if low of adjacent is greater than equal to insertion of current and parent is not -1,
 *               this means node has only one path to visit adjacent so its low is less than node's insertion, and it can't reach nodes before node so condition is >=
 *               - mark articulation[node] = 1
 *          - else adjacent is visited so set low of current node to min of (low of current, insertion of adjacent)
 *      - if parent is connected to multiple individual components so parent is articulation point
 *                   0
 *                 /   \
 *                1     2
 *               / \   / \
 *              3   4 5   6
 *        in above case 0 is articulation point as it divides graph in to 2 subcomponents
 *  - print all nodes where articulation == 1
 */
class ArticulationPoint {
    public void criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited =  new boolean[n];
        int[] low =  new int[n];
        int[] insertion =  new int[n];
        int[] articulation =  new int[n];

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
                dfs(0, -1, visited, insertion, low, graph, timer,articulation);
            }
        }
        for(int i=0;i<n;i++){
            if(articulation[i] == 1) System.out.println(i);
        }
    }

    void dfs(int node, int parent, boolean[] visited, int[] insertion, int[] low, List<List<Integer>> graph,int timer, int[] articulation){
        visited[node] =  true;
        insertion[node] = low[node] = timer++;
        int child = 0;
        for(int ad: graph.get(node)){

            if(ad == parent ||  node == ad) continue; // if adjacent is parent then ignore

            if(!visited[ad]){
                dfs(ad, node, visited, insertion, low, graph, timer,articulation);
                low[node] = Math.min(low[node], low[ad]); //set low = current low or adjacent low

                if(low[ad] >= insertion[node] && parent != -1) { // this means node has only one path to visit adjacent so its low is greater than node, and it can't reach above node so condition is >=
                    articulation[node] = 1;
                }
                child++;

            }
            else{
                low[node] = Math.min(low[node], insertion[ad]); //if node is already visited then check adj is inserted early by any other path or not if yes then made low equal to that path
            }
        }
        if(child > 1 && parent == -1) articulation[node] = 1; // if parent is connected to three individual components so parent is articulation point
    }
}