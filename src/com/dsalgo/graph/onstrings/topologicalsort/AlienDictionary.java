package com.dsalgo.graph.onstrings.topologicalsort;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/alien-dictionary/1
 * Code to solve alien dictionary using topological sort
 * Approach:
 * Time : O(N*|S| + K)
 * - Compare two string at a time and when character differs in the string1 and string 2 then create directed edge from string1 char to string2 char
 *      e.g. String1 = bca String2= bac in this case create edge from c -> a ( use numbers to indicate age i.e c = 2 and a = 0)
 * - Find topological sort for the graph that will be our answer
 */

class AlienDictionary
{
    public String findOrder(String [] dict, int N, int K)
    {
        ArrayList<ArrayList<Integer>> adjList =  new ArrayList();
        for(int i=0;i<K;i++){
            adjList.add(new ArrayList<Integer>());
        }

        int i =0 ;
        while(i<N-1){
            String word1 = dict[i];
            String word2 = dict[i+1];
            int len = 0;
            while(len < word1.length() && len < word2.length()){
                if(word1.charAt(len) != word2.charAt(len)){
                    adjList.get(word1.charAt(len)-'a').add(word2.charAt(len)-'a');
                    break;
                }
                len++;
            }
            i++;
        }
        boolean[] visited = new boolean[K];
        Stack<Integer> stack =  new Stack();
        for(int id=0;id<K;id++){
            if(!visited[id]) getTopoSort(id, adjList, visited, stack);
        }

        StringBuilder sb =  new StringBuilder();
        while(!stack.isEmpty()){
            sb.append((char)(stack.pop()+'a'));
        }
        return sb.toString();
    }

    private void getTopoSort(int node,ArrayList<ArrayList<Integer>> adjList, boolean[] visited, Stack<Integer> stack){
        visited[node] =  true;
        for(int i: adjList.get(node)){
            if(!visited[i]){
                getTopoSort(i, adjList, visited, stack);
            }
        }
        stack.push(node);
    }
}