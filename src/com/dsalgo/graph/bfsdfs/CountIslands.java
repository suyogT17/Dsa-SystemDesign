package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * Time: O(n*m)
 * Find the number of islands - using bfs
 */
class CountIslands {
    public int numIslands(char[][] grid) {
        int island = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i , j);
                    island++;
                }
            }
        }
        return island;
    }
    private void bfs(char[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j >= grid[0].length || j < 0 || grid[i][j] != '1' ) return;
        grid[i][j] = '0'; //visit and make it 0 so that it could not a part of any another island
        bfs(grid,i-1,j);
        bfs(grid,i-1,j+1);
        bfs(grid,i,j+1);
        bfs(grid,i+1,j+1);
        bfs(grid,i+1,j);
        bfs(grid,i+1,j-1);
        bfs(grid,i,j-1);
        bfs(grid,i-1,j-1);
    }
}