package com.dsalgo.graph.undirectedgraphs;

import java.util.*;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/shortest-path-in-an-unweighted-graph_981297
 * Code to find The Shortest path in an unweighted graph using BFS
 * Approach:
 * -Time = O(V+E) Space=O(n+n+n)(for queue, dist and path array) (V = Vertex, E = Edges)
 * -BFS:
 *   - Maintain queue of node and add source node in it
 *   - Maintain distance and path array to store shorted distance and prev node to generate path.
 *   - Fill distance array with Integer.MAX_VALUE and path with -1
 *   - Set source element distance as 0
 *   - Run till queue is not empty
 *     - Remove element from the queue and traverse its adjacent element
 *     - if current max distance to reach adjacent is greater than (distance to reach current + 1)
 *          - then set new distance to reach adjacent as (distance to reach current + 1)
 *          - set the node to reach adjacent as current by setting path[adjacent] = curr
 *          - add the adjacent element in the queue
 *     - Traverse from end element to generate the path
 *     - reverse the output and return
 */
public class ShortestPathUndirectedBfs {

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]-1).add(edges[i][1]-1);
            adj.get(edges[i][1]-1).add(edges[i][0]-1);
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] path = new int[n];
        Arrays.fill(path, -1);

        Queue<Integer> queue = new LinkedList();
        queue.offer(s-1);
        dist[s-1] = 0;
        while(!queue.isEmpty()){
            int curr  = queue.poll();
            for(int i: adj.get(curr)){

                if(dist[i] > dist[curr] + 1){
                    dist[i] = dist[curr] + 1;
                    path[i] = curr+1;
                    queue.add(i);
                }
            }
        }
        LinkedList<Integer> output =  new LinkedList();
        output.add(t);
        while(path[t-1] != -1){
            output.add(path[t-1]);
            t = path[t-1];
        }
        Collections.reverse(output);
        return output;
    }

}