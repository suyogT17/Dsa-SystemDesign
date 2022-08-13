package com.dsalgo.graph.minimumspanningtree;

import java.util.PriorityQueue;

/**
 * Implementation of Kruskal's algo
 * Approach:
 *  - Time = VLogV(for sorting) + V*4(alpha)(for disjoint set) = VLogV
 *  - sort the edges by weight
 *  - iterate over each edge
 *      - if their parent id different then
 *          - add that edge to ans
 *          - perform union on nodes present in that edge
 */
public class Kruskals {
    static int KruskalsAlgo(int V, int[][] edges) {

        PriorityQueue<Tuple3> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        for (int[] edge : edges)
            pq.add(new Tuple3(edge[0], edge[1], edge[2]));

            DisjointSet disjointSet = new DisjointSet(V);

            int ans = 0;
            while (!pq.isEmpty()) {
                Tuple3 curr = pq.poll();
                if (disjointSet.findParent(curr.node2) != disjointSet.findParent(curr.node1)) { // if equals means already connected and if we connect them again then it will form cycle
                    ans += curr.weight;
                    disjointSet.union(curr.node2, curr.node1);
                }
            }
        return ans;
    }
}
