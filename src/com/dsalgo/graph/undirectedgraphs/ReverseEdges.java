package com.dsalgo.graph.undirectedgraphs;

import java.util.*;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/reverse-edges_1200162
 * here at each edge created reverse edge and added it distance as 1
 * so which ever edge getting used that's edge will get add as 1
 */
public class ReverseEdges {
    public static int reverseEdges(int n, int start, int end, ArrayList<ArrayList<Integer>> edgeList) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Pair>());
        }
        for (ArrayList<Integer> edge : edgeList) {
            adjList.get(edge.get(0)).add(new Pair(edge.get(1), 0));
            adjList.get(edge.get(1)).add(new Pair(edge.get(0), 1));
        }
        int[] distance = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Pair(start, 0));
        distance[start] = 0;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (Pair ad : adjList.get(curr.node)) {
                if (distance[ad.node] > distance[curr.node] + ad.distance) {
                    distance[ad.node] = distance[curr.node] + ad.distance;
                    pq.add(new Pair(ad.node, distance[ad.node]));
                }
            }
        }
        return distance[end];
    }
}
