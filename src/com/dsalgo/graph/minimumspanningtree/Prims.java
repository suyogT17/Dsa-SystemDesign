package com.dsalgo.graph.minimumspanningtree;

import com.dsalgo.graph.undirectedgraphs.Pair;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Problem Link: 
 * Implemented Prim's algorithm
 * Approach 1:
 * - Time = O(N^2)
 * - maintain int array for key and parent and boolean array for visited
 * - fill key array with Integer.MAX_VALUE
 * - fill parent array with -1
 * - fill visited array with false
 * - set key[0] = 0, parent[0] = -1 and visited[0] =  true;
 * - run loop from 0 to V-1
 *   - find min value node(u) from key's array where visited[i] != false;
 *   - mark it as visited
 *   - add its weight to answer
 *   - travel adjacent of that node
 *     - if adjacent are not visited and key[adjacent] > current adjacent weight
 *       - set parent[adjacent] = min value node(u)
 *       - update key[adjacent] = current adjacent weight;
 *   - at the end return the answer
 * Approach 2: (Optimize using heap)
 * - Time = O(NLogN)
 * - maintain int array for parent and boolean array for visited and heap to store pair of <node,weight>
 * - fill parent array with -1
 * - fill visited array with false
 * - set parent[0] = -1 and visited[0] =  true and add Pair(0,0) in heap;
 * - run loop till heap is not empty
 *   - find min value node(u) from heap
 *   - if node is already visited then move to next iteration
 *   - else
 *     - mark it as visited
 *     - add its weight to answer
 *     - travel adjacent of that node
 *     - if adjacent are not visited
 *       - set parent[adjacent] = min value node(u)
 *       - add Pair(adjacent.node, adjacent.weight) to heap
 *   - at the end return the answer
 */

public class Prims {
    static int primsAlgoBruteForce(int V, ArrayList<ArrayList<Pair>> adj)
    {
        int[] key =  new int[V];
        boolean[] visited =  new boolean[V];
        int[] parent =  new int[V];

        for(int i=0;i<V;i++){
            key[i] = Integer.MAX_VALUE;
            visited[i] = false;
            parent[i] = -1;
        }
        
        key[0] = 0;
        int ans = 0;
        for(int i=0;i<V;i++){
            int min = Integer.MAX_VALUE, u=0;
            //finding minimum node from the key array
            for(int x=0;x<V;x++){
                if(visited[x] == false && min > key[x]){
                    min = key[x];
                    u = x;
                }
            }
            
            //marking min node as part of visited
            visited[u] = true;
            ans+=key[u];
            
            //travelling adjacent nodes and checking if edge cost to reach them is minimum of not
            for(Pair ad: adj.get(u)){
                if(visited[ad.node] == false && key[ad.node] > ad.distance){
                    key[ad.node] = ad.distance;
                    parent[ad.node] = u;
                }
            }
        }
        return ans;
    }

    static int primsAlgoOptimized(int V, ArrayList<ArrayList<Pair>> adj)
    {
        boolean[] visited =  new boolean[V];
        int[] parent =  new int[V];

        for(int i=0;i<V;i++){
            visited[i] = false;
            parent[i] = -1;
        }

        PriorityQueue<Pair> pq =  new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        pq.offer(new Pair(0,0));
        int ans = 0;
        //using priority queueu to get minimum node
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int u = node.node;
            if(visited[u] == true) continue; // if min node is already visited then return 
            
            //marking min node as part of visited
            visited[u] = true;
            ans+=node.distance;
            
            //travelling adjacent nodes and adding node and its edge cost
            for(Pair ad: adj.get(u)){
                if(visited[ad.node] == false){
                    parent[ad.node] = u;
                    pq.add(new Pair(ad.node, ad.distance));
                }
            }
        }
        return ans;
    }
}
