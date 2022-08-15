package com.dsalgo.graph.minimumspanningtree;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
 * Code for Number of Operations to Make Network Connected
 * Solved using Prim's and Kruskal's algo
 * Time: O(VLogV)
 */
class MakeNetworkConnected {
    public int makeConnectedKruskal(int n, int[][] connections) {
        return kruskals(connections,n);
    }

    public int makeConnectedPrims(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adj =  new ArrayList();
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i[]: connections){
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        int finalCount = 0;
        int components = 0;
        for(int i =0;i<n;i++){
            if(!visited[i]){
                finalCount += prims(adj, n, i,visited);    // min edges required to connect separate component
                components++;   // counting components
            }
        }
        /**
         * if number of edges present - used edges > edges required to join remaining components
         */
        return (connections.length - finalCount >= components-1) ? components-1:-1;
    }

    public int prims(ArrayList<ArrayList<Integer>> adj, int n, int i, boolean[] visited){
        Queue<Integer> queue = new LinkedList();
        queue.add(i);
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(visited[curr]) continue;

            visited[curr] = true;
            count++;    // counting edges picked to connect two nodes

            for(int ad: adj.get(curr)){
                if(!visited[ad])
                    queue.add(ad);
            }
        }
        return count-1;
    }

    private int kruskals(int[][] connections, int n){
        int[] rank =  new int[n];
        int[] parent =  new int[n];

        Arrays.fill(rank, 0);
        for(int i=0;i<parent.length;i++) parent[i] = i;
        Queue<Pair> queue = new LinkedList();
        int count = 0;
        int components = n;
        for(int[] connection: connections){
            queue.add(new Pair(connection[0], connection[1]));
            while(!queue.isEmpty()){
                Pair curr =  queue.poll();
                if(findParent(curr.node1, parent) != findParent(curr.node2, parent)){
                    count++;    // counting edges used to join nodes
                    components--;   // reducing components as they are getting joined
                    union(curr.node1, curr.node2, rank, parent);
                }
            }
        }
        return (connections.length - count >= components-1) ? components-1:-1;
    }

    private int findParent(int node, int[] parent){
        if(node == parent[node]) return node;
        parent[node] =  findParent(parent[node], parent);
        return parent[node];
    }

    private void union(int node1, int node2, int[] rank, int[] parent){
        int node1Parent = findParent(node1, parent);
        int node2Parent = findParent(node2, parent);

        if(rank[node1Parent] < rank[node2Parent]){
            parent[node1Parent] = node2Parent;
        }
        else if (rank[node1Parent] > rank[node2Parent]){
            parent[node2Parent] = node1Parent;
        }
        else {
            rank[node1Parent]++;
            parent[node2Parent] = node1Parent;
        }
    }
}

class Pair{
    int node1, node2;
    public Pair(int node1, int node2){
        this.node1=  node1;
        this.node2 = node2;
    }
}