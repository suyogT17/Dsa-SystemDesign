package com.dsalgo.graph.minimumspanningtree;

import java.util.Arrays;

/**
 * Implementation of Kruskal's algo
 * Approach:
 * - Time = VLogV(for sorting) + V*4(alpha)(for disjoint set) = VLogV
 * - sort the edges by weight
 * - iterate over each edge
 * - if their parent id different then
 * - add that edge to ans
 * - perform union on nodes present in that edge
 */
public class Kruskals {
    static int KruskalsAlgo(int V, int[][] edges) {
        DisjointSet disjointSet = new DisjointSet(V);
        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        int ans = 0;
        for (int[] edge : edges) {
            if (disjointSet.findParent(edge[0]) != disjointSet.findParent(edge[1])) { // if equals means already connected and if we connect them again then it will form cycle
                ans += edge[2];
                disjointSet.union(edge[0], edge[1]);
            }
        }
        return ans;
    }
}
