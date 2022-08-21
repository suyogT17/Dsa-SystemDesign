package com.dsalgo.graph.directedgraphs;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/
 * Solved using Bellman-ford
 * Time: (k)*(E)
 */
class CheapestFlight {
    int min= Integer.MAX_VALUE;
    int ans_dfs;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[] cost=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<=K;i++)
        {
            int[] temp= Arrays.copyOf(cost,n);
            for(int[] f: flights)
            {
                int curr=f[0],next=f[1],price=f[2];
                if(cost[curr] == Integer.MAX_VALUE) continue;
                if(temp[next] > cost[curr]+price){
                    temp[next] = cost[curr]+price;
                }
            }
            cost = temp;
        }
        return cost[dst]==Integer.MAX_VALUE?-1:cost[dst];
    }

    public int findCheapestPrice3(int n, int[][] flights, int src, int dst, int K)
    {
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] f:flights)
        {
            map.putIfAbsent(f[0],new ArrayList<>());
            map.get(f[0]).add(new int[]{f[1],f[2]});
        }
        PriorityQueue<int[]> q=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        q.offer(new int[]{0,src,K+1});
        while(!q.isEmpty())
        {
            int[] c=q.poll();
            int cost=c[0];
            int curr=c[1];
            int stop=c[2];
            if(curr==dst)
                return cost;
            if(stop>0)
            {
                if(!map.containsKey(curr))
                    continue;
                for(int[] next:map.get(curr))
                {
                    q.add(new int[]{cost+next[1],next[0],stop-1});
                }
            }
        }
        return -1;
    }

    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K)
    {
        ans_dfs=Integer.MAX_VALUE;
        Map<Integer,List<int[]>> map=new HashMap<>();
        for(int[] i:flights)
        {
            map.putIfAbsent(i[0],new ArrayList<>());
            map.get(i[0]).add(new int[]{i[1],i[2]});
        }
        dfs(map,src,dst,K+1,0);
        return ans_dfs==Integer.MAX_VALUE?-1:ans_dfs;
    }
    public void dfs(Map<Integer,List<int[]>> map, int src, int dst, int k, int cost)
    {
        if(k<0)
            return;
        if(src==dst)
        {
            ans_dfs=cost;
            return;
        }
        if(!map.containsKey(src))
            return;
        for(int[] i:map.get(src))
        {
            if(cost+i[1]>ans_dfs)               //Pruning, check the sum of current price and next cost. If it's greater then the ans so far, continue
                continue;
            dfs(map,i[0],dst,k-1,cost+i[1]);
        }
    }
}

