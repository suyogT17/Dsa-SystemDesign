package com.dsalgo.graph.directedgraphs;

import java.util.*;

/**
 * Implementation of Bellman Ford Algorithm to find the shortest distance in directed graph where no negative cycle present
 * Dijkstra's algorithm don't work on the negative edges
 * Steps in bellman ford:
 * - maintain distance array set all values to 100000000 and source to 0
 * - relax all edges of the graph for n-1 times
 *  - relaxation means
 *      - iterate over each edge and check if (distance[u] +weight) < distance[v] if yes then update distance[v] = (distance[u] +weight)
 *  - after the relaxation process the distance array will contain the shortest distance
 *  - to check if negative cycle present or not
 *      - perform relaxation once and check if any distance is changing or not. if distance changed then graph contains negative cycle
 */

class BellmanFord
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S)
    {
        // Write your code here
        int[] distance =  new int[V];
        Arrays.fill(distance, 100000000);  //consider 100000000 as infinity
        distance[S] = 0;
        for(int i=1;i<V;i++){
            for(ArrayList<Integer> it: adj){
                if(distance[it.get(0)] + it.get(2) < distance[it.get(1)]){
                    distance[it.get(1)] = distance[it.get(0)] + it.get(2);
                }
            }
        }

        for(ArrayList<Integer> it: adj){
            if(distance[it.get(0)] + it.get(2) < distance[it.get(1)]){
                System.out.println("Cycle present");
                break;
            }
        }

        return distance;
    }
}