package com.dsalgo.graph.minimumspanningtree;

/**
 * implementation of disjoint set using union by rank and path compression
 * Union by rank:
 * - steps to perform union on a and b
 *  - find the parent of node a and b
 *  - parent should not be equal
 *  - if rank of aParent < bParent then assign aParent = bParent
 *  - else if rank of aParent > bParent then assign bParent = aParent
 *  - else if rank is equal then assign aParent = bParent or else can assign bParent = aParent
 *      increment rank of node who is become parent
 * - Path Compression
 *  - If parent of a is d with path a -> b -> c -> d
 *  - then we can compress this path for a to a -> d. similarly for b and c.  b -> d and c -> d
 */
public class DisjointSet{

    int[] rank = null;
    int[] parent = null;

    public DisjointSet(int V){
        rank =  new int[V];
        parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
    }

    int findParent(int node){
        if(node == parent[node]) return node;
        parent[node] = findParent(parent[node]); // path compression
        return parent[node];
    }


    void union(int node1, int node2){
        int node1Parent = findParent(node1);
        int node2Parent = findParent(node2);

        if(rank[node1Parent] < rank[node2Parent]){
            parent[node1Parent] = node2Parent;
        }
        else if(rank[node1Parent] > rank[node2Parent]){
            parent[node2Parent] = node1Parent;
        }
        else{
            parent[node1Parent] = node2Parent;
            rank[node1Parent]++;
            rank[node2Parent]++;
        }
    }
}
