package com.dsalgo.graph.undirectedgraphs;

import com.dsalgo.graph.bfsdfs.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgo {
    public static void main(String[] args) {
        int V = 3;
        int[][] edges = new int[][]{new int[]{0,1,1}, new int[]{1,2,3},new int[]{0,2,6}};
        UndirectedAcyclicGraph undirectedAcyclicGraph =  new UndirectedAcyclicGraph(V);
        undirectedAcyclicGraph.createGraph(edges);
        int S = 2;
        int[] distance = dijkstra(V, undirectedAcyclicGraph.adjList,S);
        System.out.println(Arrays.toString(distance));
    }

    private static int[] dijkstra(int V, ArrayList<ArrayList<Pair>> adjList, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((o1, o2) -> o1.distance - o2.distance);
        int[] distance =  new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Pair(S,0));
        distance[S] = 0;

        while(!pq.isEmpty()){

            Pair curr = pq.poll();
            for(Pair i: adjList.get(curr.node)){
                if(distance[i.node] > distance[curr.node] + i.distance){
                    distance[i.node] = distance[curr.node] + i.distance;
                    pq.add(new Pair(i.node, distance[i.node]));
                }
            }
        }
        return distance;
    }
}
