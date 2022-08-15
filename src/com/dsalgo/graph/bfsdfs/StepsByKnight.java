package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
 * Code for Steps by Knight - using BFS
 * Time : N^2 Space : N^2
 * Modified BFS based on how knight travels on chess board. (3 steps)
 * Stored visited time in visited array
 *      steps to visit next location = (steps to visit current location + 1)
 * return the visited time got to visit target by visited[target[0]-1][target[1]-1] (1 based indexing)
 */

public class StepsByKnight
{
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        if(KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1] ) return 0;
        int visited[][] =  new int[N][N];

        Queue<Pair> queue =  new LinkedList();
        queue.add(new Pair(KnightPos[0]-1, KnightPos[1]-1));
        visited[KnightPos[0]-1][KnightPos[1]-1] = 0;
        while(!queue.isEmpty()){
            Pair p =  queue.poll();
            checkIfSafe(p.i-2,p.j-1, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i-1,p.j-2, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i+1,p.j-2, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i+2,p.j-1, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i+2,p.j+1, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i+1,p.j+2, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i-1,p.j+2, visited, queue,N, p.i,p.j);
            checkIfSafe(p.i-2,p.j+1, visited, queue,N, p.i,p.j);
        }
        return (visited[TargetPos[0]-1][TargetPos[1]-1] == 0)? -1:visited[TargetPos[0]-1][TargetPos[1]-1];
    }

    void checkIfSafe(int i, int j, int visited[][], Queue<Pair> queue, int N, int curri, int currj){
        if(i < N && i >= 0 && j < N && j>=0 && visited[i][j] == 0){
            queue.add(new Pair(i,j));
            visited[i][j] = visited[curri][currj]+1;
        }
    }
}

class Pair{
    int i, j;
    public Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}