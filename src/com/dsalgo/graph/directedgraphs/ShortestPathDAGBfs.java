package com.dsalgo.graph.directedgraphs;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Code to find The Shortest path in an weighted directed acyclic graph (DAG) using topological sort and BFS
 * Approach:
 * -Time = O(V+E) Space=O(n+n+n)(for stack and topoSort,dist array) (V = Vertex, E = Edges)
 * - Find the topological sort
 *   - The reason of using topological sort is simple, we save a lot of time by starting from the start point, instead of starting from any random point.
 *     Since we know via topological sort we get to know the starting point, hence it becomes optimal to use topological sort!
 *   - Also if we get the shortest path than the previous path then in case of normal BFS and DFS need to update the distance of all the adjacent node and that
 *     can degrade the performance. so by finding topological sort we already get the node which are appearing first.
 * -BFS:
 *   - Maintain distance array to store shorted distance.
 *   - Fill distance array with Integer.MAX_VALUE
 *   - Set source element distance as 0
 *   - Run over the nodes in topological sort and perform
 *     - Get the node and traverse its adjacent nodes
 *     - if distance of node not equal to Integer.MAX_VALUE means if node is already reached then perform
 *          -if current max distance to reach adjacent is greater than (distance to reach current + distance to reach adjacent)
 *              - set new distance to reach adjacent as (distance to reach current + distance to reach adjacent)
 *   - return distance[destination] to get min path from source to destination
 */
public class ShortestPathDAGBfs {

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = new int[][]{new int[]{0,1,2}, new int[]{0,4,1},new int[]{1,2,3},new int[]{3,2,6},new int[]{4,2,2}, new int[]{4,5,4}, new int[]{3,5,1}};
        DirectedAcyclicGraph directedAcyclicGraph = new DirectedAcyclicGraph(V);
        directedAcyclicGraph.createGraph(edges);
        ArrayList<Integer> topoSort = directedAcyclicGraph.generateTopologicalSort();
        int source = 0, dest = 3;
        int distance  = findShortedDistance(topoSort, source, dest, directedAcyclicGraph.adjList ,V);
        if(distance != Integer.MAX_VALUE) System.out.println("Distance to reach "+source+" to "+dest+" is: "+distance);
        else System.out.println(dest+" not reachable from "+source);
    }

    private static int findShortedDistance(ArrayList<Integer> topoSort, int source, int dest, ArrayList<ArrayList<Pair>> adjList, int V){
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for(int node: topoSort){
            //if node is already reached then only perform else it will add Integer.MAX_VALUE + weight
            if(distance[node] != Integer.MAX_VALUE) {
                for (Pair i : adjList.get(node)) {
                    if (distance[i.node] > distance[node] + i.weight) {
                        distance[i.node] = distance[node] + i.weight;
                    }
                }
            }
        }
        return distance[dest];
    }
}
