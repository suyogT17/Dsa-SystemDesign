package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * Rat in a Maze Problem - I - solve using DFS
 * Time: O(4^N*N)
 */
class RatInMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here

        ArrayList<String> output =  new ArrayList();
        boolean[][] visited = new boolean[n][n];
        dfs(m, 0,0,visited, output,n, "");
        return output;
    }

    private static void dfs(int[][] m, int i, int j, boolean[][] visited, ArrayList<String> output, int n, String path){
        if(i < 0 || i >= n || j < 0 || j>=n ) return; //if rat is going out of maze boundries
        if(m[i][j] == 0 || visited[i][j]) return; // if cell in the maze has 0  then can't move from that cell
        visited[i][j] = true;
        if(i == n-1 && j == n-1) { //reaches the end node in the maze
            output.add(path);
            visited[i][j] = false;
            return;
        }
        dfs(m,i-1,j, visited, output, n,path+"U");
        dfs(m,i+1,j, visited, output, n,path+"D");
        dfs(m,i,j-1, visited, output, n,path+"L");
        dfs(m,i,j+1, visited, output, n,path+"R");
        visited[i][j] = false;      // backtracking
    }
}