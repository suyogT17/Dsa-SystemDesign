package com.dsalgo.queue;

import com.dsalgo.tree.Node;

import java.util.*;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/check-if-all-levels-of-two-trees-are-anagrams-or-not/1
 */
class AllLevelOfTreeAnagram {

    static class Pair {
        Node value;
        int row;

        public Pair(Node value, int row) {
            this.value = value;
            this.row = row;
        }
    }

    public static boolean areAnagrams(Node node1, Node node2) {
        // code here
        Queue<Pair> queue = new LinkedList<Pair>();
        Map<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
        Map<Integer, List<Integer>> map2 = new HashMap<Integer, List<Integer>>();
        queue.offer(new Pair(node1, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            List<Integer> temp = null;
            if (map1.containsKey(curr.row)) {
                temp = map1.get(curr.row);
            } else {
                temp = new ArrayList();
            }
            temp.add(curr.value.data);
            map1.put(curr.row, temp);
            if (curr.value.left != null) {
                queue.offer(new Pair(curr.value.left, curr.row + 1));
            }
            if (curr.value.right != null) {
                queue.offer(new Pair(curr.value.right, curr.row + 1));
            }
        }
        //System.out.println(map1);
        queue.offer(new Pair(node2, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            List<Integer> temp = null;
            if (map2.containsKey(curr.row)) {
                temp = map2.get(curr.row);
            } else {
                temp = new ArrayList();
            }
            temp.add(curr.value.data);
            map2.put(curr.row, temp);
            if (curr.value.left != null) {
                queue.offer(new Pair(curr.value.left, curr.row + 1));
            }
            if (curr.value.right != null) {
                queue.offer(new Pair(curr.value.right, curr.row + 1));
            }
        }
        //System.out.println(map2);
        if (map1.size() != map2.size()) {
            //System.out.println("returning false for map  size not matching");
            return false;
        } else {
            for (int i = 0; i < map1.size(); i++) {
                if (!compare(map1.get(i), map2.get(i))) {
                    //System.out.println("returning false for comparison failed");
                    return false;
                }
            }
        }
        return true;
    }


    static boolean compare(List<Integer> list1, List<Integer> list2) {
        //System.out.println("comparing: "+list1+" with "+list2);
        if (list1.size() != list2.size()) return false;
        Collections.sort(list1);
        Collections.sort(list2);
        for (int i = 0; i < list1.size(); i++) {
            //System.out.println("comparing: "+list1.get(i)+" with "+list2.get(i)+" = "+(list1.get(i).intValue() == list2.get(i).intValue()));
            if (list1.get(i).intValue() != list2.get(i).intValue()) return false;
        }
        return true;
    }
}

