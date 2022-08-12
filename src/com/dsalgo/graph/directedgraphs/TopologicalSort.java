package com.dsalgo.graph.directedgraphs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/topological-sort/1
 * Code to print Topological Sort of graph using BFS(Kahn's Algo -> Iterative)
 * What id Topological Sort:
 * - Linear ordering of the vertices such that, if there is a edge U -> V then U appears before V in that ordering
 *
 * Approach:
 * -Time = O(V+E) Space=O(n+n)(for queue and indegree/visited Array) (V = Vertex, E = Edges)
 * - DFS
 *   - Maintain visited array and stack
 *   - Perform DFS call for each node in the graph which is not visited
 *   - Mark node as visited and then call dfs for all the unvisited adjacent nodes
 *   - Once processing of all the nodes completed then add the node in stack
 *   - By above approach if U -> V, then V will be pushed into the stack first. that will make U appear first in the output.
 * -BFS:
 *   - Maintain in-degree array (to store in-degree of each node) and queue
 *   - Calculate the in-degree of each node in the graph ans store in the output
 *   - Add the nodes having in-degree O into the queue (As graph is DAG then there will be at least 1 node Having in-degree 0
 *   - Perform below steps till queue becomes empty
 *     - Remove the element from queue and add in the output of topoSort
 *     - Traverse the adjacent nodes of the removed element and reduce their in-degree by 1
 *     - After reducing any of the node's in-degree becomes 0 then add it in the queue.
 */

public class TopologicalSort
{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //DFS call for topological sort
        Stack<Integer> stack =  new Stack();
        boolean[]  visited = new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfsRec(i, adj, visited, stack);
            }
        }

        int ans[] =  new int[V];
        int i=0;
        while(!stack.isEmpty()){
            ans[i++] = stack.pop();
        }
        return ans;

        //Bfs-Kanh's Algo call for topological Sort
        //return bfsKanhs(V, adj);
    }

    private static void dfsRec(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack){
        visited[node] =  true;
        for(int i: adj.get(node)){
            if(!visited[i]){
                dfsRec(i, adj, visited, stack);
            }
        }
        stack.add(node);
    }

    private static int[] bfsKanhs(int V,ArrayList<ArrayList<Integer>> adj){
        int[] topoSort =  new int[V];
        int[] indegree =  new int[V];

        //code to calculate in-degree
        for(int i=0;i<V;i++){
            for(int ad : adj.get(i)){
                indegree[ad]++;
            }
        }

        Queue<Integer> queue =  new LinkedList();
        for(int i=0;i<V;i++){
            if(indegree[i] == 0) queue.add(i);
        }

        int index= 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            topoSort[index++] = curr;

            for(int ad: adj.get(curr)){
                if(--indegree[ad] == 0) queue.add(ad);
            }
        }
        return topoSort;
    }
}
