package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/find-if-there-is-a-path-of-more-than-k-length-from-a-source_1229512
 * Solved using DFS
 * Time: O(VE) as we are trying every combination
 */
public class PathMoreThanDistanceK {
    public static String pathMoreThanK(int n, int m, int k, int[][] edges) {
        // Write your code here.
        ArrayList<ArrayList<Tuple>> adjList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Tuple>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(new Tuple(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Tuple(edge[0], edge[2]));
        }
        boolean[] visited = new boolean[n];
        return dfs(0, k, adjList, visited, 0) ? "YES" : "NO";
    }

    static boolean dfs(int node, int k, ArrayList<ArrayList<Tuple>> adjList, boolean[] visited, int cost) {
        if (cost >= k) return true;
        visited[node] = true;
        for (Tuple ad : adjList.get(node)) {
            if (!visited[ad.node]) {
                if (dfs(ad.node, k, adjList, visited, cost + ad.weight)) return true;
            }
        }
        visited[node] = false;
        return false;
    }
}

class Tuple {
    int node, weight;

    public Tuple(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}
/*
9 14 60
0 1 4
0 7 8
1 2 8
1 7 11
2 3 7
2 5 4
2 8 2
3 4 9
3 5 14
4 5 10
5 6 2
6 7 1
6 8 6
7 8 7
*/