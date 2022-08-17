package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 * Code for M-Coloring Problem
 * Approach:
 * Time: N^M (N nodes and M colors
 * Iterate over each node and try all three color if we reach till last node by coloring this way then answer is true else false
 */
class MColor {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here

        int[] color =  new int[n];
        Arrays.fill(color, -1);

        ArrayList<ArrayList<Integer>> adjList =  new ArrayList();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].length;j++){
                if(graph[i][j] == true){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        return colorGraph(0, m,adjList, color,n);
    }

    boolean isSafe(int node , ArrayList<ArrayList<Integer>> adjList, int[] color, int col){
        for(int ad: adjList.get(node)){
            if(color[ad] == col) return false;
        }
        return true;
    }

    boolean colorGraph(int node , int m, ArrayList<ArrayList<Integer>> adjList, int[] color,int n){
        if(node == n) return true;

        for(int i=1;i<=m;i++){
            if(isSafe(node,adjList, color, i)){
                color[node] = i;
                if(colorGraph(node+1, m,adjList, color,n)) return true;
                color[node] = 0;
            }
        }
        return false;
    }
}