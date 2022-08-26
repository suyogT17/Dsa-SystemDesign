package com.dsalgo.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
 * 0 : Empty cell
 * 1 : Cells have fresh oranges
 * 2 : Cells have rotten oranges
 *
 * We have to determine what is the minimum time required to rot all oranges. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
 *
 *
 * Example 1:
 *
 * Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
 * Output: 1
 * Explanation: The grid is-
 * 0 1 2
 * 0 1 2
 * 2 1 1
 * Oranges at positions (0,2), (1,2), (2,0)
 * will rot oranges at (0,1), (1,1), (2,2) and
 * (2,1) in unit time.
 */
class RottenMangoes {
    //Function to find minimum time required to rot all oranges.
    class Store {
        int index;
        int i, j;

        public Store(int index, int i, int j) {
            this.index = index;
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Store> queue = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    Store s = new Store(0, i, j);
                    queue.offer(s);
                }
            }
        }
        int ans = -1;
        while (!queue.isEmpty()) {
            Store temp = queue.poll();
            ans = temp.index;
            addToQueue(temp, grid, queue);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    void addToQueue(Store temp, int[][] grid, Queue<Store> queue) {
        if (temp.j - 1 >= 0 && grid[temp.i][temp.j - 1] == 1) {
            grid[temp.i][temp.j - 1] = 2;
            Store s = new Store(temp.index + 1, temp.i, temp.j - 1);
            queue.offer(s);
        }
        if (temp.i - 1 >= 0 && grid[temp.i - 1][temp.j] == 1) {
            grid[temp.i - 1][temp.j] = 2;
            Store s = new Store(temp.index + 1, temp.i - 1, temp.j);
            queue.offer(s);
        }
        if (temp.j + 1 < grid[temp.i].length && grid[temp.i][temp.j + 1] == 1) {
            grid[temp.i][temp.j + 1] = 2;
            Store s = new Store(temp.index + 1, temp.i, temp.j + 1);
            queue.offer(s);
        }
        if (temp.i + 1 < grid.length && grid[temp.i + 1][temp.j] == 1) {
            grid[temp.i + 1][temp.j] = 2;
            Store s = new Store(temp.index + 1, temp.i + 1, temp.j);
            queue.offer(s);
        }
    }
}