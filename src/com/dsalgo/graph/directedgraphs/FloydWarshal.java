package com.dsalgo.graph.directedgraphs;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
 * Code to implement in place floyd warshal algorithm
 * Time: O(n^3)
 * DP formula = A[i,j] = Min(A[i,j], A[i,k]+A[k,j] -> iterate over each node that is our k
 */
class FloydWarshal
{
    public void shortest_distance(int[][] matrix)
    {
        for(int k=0;k<matrix.length;k++){
            for(int i=0;i<matrix.length;i++){
                for(int j= 0;j<matrix[i].length;j++){
                    if(i == j) continue;
                    else if(i==k || j == k) continue;
                    else {
                        //converting -1 into some large value here 100000000
                        matrix[i][j] = Math.min((matrix[i][j] == -1)?100000000:matrix[i][j] ,((matrix[i][k] == -1)?100000000:matrix[i][k])+((matrix[k][j] == -1)?100000000:matrix[k][j]));
                    }
                }
            }
        }
    }
}