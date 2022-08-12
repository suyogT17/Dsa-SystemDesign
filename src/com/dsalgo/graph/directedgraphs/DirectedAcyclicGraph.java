package com.dsalgo.graph.directedgraphs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementation of Directed Acyclic Graph with weights
 */

public class DirectedAcyclicGraph {

    public ArrayList<ArrayList<Pair>> adjList =  new ArrayList<ArrayList<Pair>>();
    private int V = 0;
    public DirectedAcyclicGraph(int V){
        this.V = V;
        for(int i = 0;i<V;i++){
            adjList.add(new ArrayList<Pair>());
        }
    }

    void addEdge(int from, int to, int weight){
        adjList.get(from).add(new Pair(to, weight));
    }

    public void createGraph(int[][] edges){
        for(int[] edge: edges){
            addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public ArrayList<Integer> generateTopologicalSort(){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack =  new Stack<>();
        for(int i=0;i<V;i++) {
            if (!visited[i]) {
                findTopologicalSortUsingDFS(i, visited, stack);
            }
        }
        ArrayList<Integer> topoSort = new ArrayList<>();
        while(!stack.isEmpty()) topoSort.add(stack.pop());
        return topoSort;
    }

    private void findTopologicalSortUsingDFS(int node, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(Pair pair: adjList.get(node)){
            if(!visited[pair.node]){
                findTopologicalSortUsingDFS(pair.node, visited, stack);
            }
        }
        stack.push(node);
    }
}
