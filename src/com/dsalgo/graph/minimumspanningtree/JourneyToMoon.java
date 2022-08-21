package com.dsalgo.graph.minimumspanningtree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Link: https://www.hackerrank.com/challenges/journey-to-the-moon/problem
 */
public class JourneyToMoon {
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        DisjointSet disjointSet = new DisjointSet(n);
        for (List<Integer> ast : astronaut) {
            if (disjointSet.parent[ast.get(0)] != disjointSet.parent[ast.get(1)]) {
                disjointSet.union(ast.get(0), ast.get(1));
            }
        }
        for (int i = 0; i < n; i++) {
            disjointSet.findParent(i);
        }
        long newN = (long) n;
        long total = (newN * (newN - 1)) / 2;
        Map<Integer, Integer> countMap = new HashMap();
        for (int i = 0; i < disjointSet.parent.length; i++) {
            countMap.put(disjointSet.parent[i], countMap.getOrDefault(disjointSet.parent[i], 0) + 1);
        }
        List<Integer> list = countMap.values().stream().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            long x = (list.get(i) * (list.get(i) - 1)) / 2;
            total -= x;
        }
        return total;
    }
}