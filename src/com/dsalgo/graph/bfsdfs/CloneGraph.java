package com.dsalgo.graph.bfsdfs;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/clone-graph/
 * Code to clone graph - using BFS and DFS
 * Time: O(V+E*LogV)
 */
public class CloneGraph {
    public Node cloneGraphBFS(Node node) {
        if(node == null) return null;
        Node clonedNode = new Node(node.val);

        Map<Node, Node> visited =  new HashMap();

        Queue<Node> queue=  new LinkedList();
        queue.add(node);
        visited.put(node, clonedNode);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for(Node n: curr.neighbors){
                if(!visited.containsKey(n)){
                    visited.put(n, new Node(n.val));
                    queue.add(n);
                }
                visited.get(curr).neighbors.add(visited.get(n));
            }
        }
        return clonedNode;
    }

    public Node cloneGraphDFS(Node node) {
        if(node == null) return null;
        Node clonedNode = new Node(node.val);
        Map<Node, Node> visited =  new HashMap();
        dfs(node,visited);
        return visited.get(node);
    }

    void dfs(Node node, Map<Node, Node> visited){
        visited.put(node, new Node(node.val));
        for(Node n: node.neighbors){
            if(!visited.containsKey(n)){
                dfs(n, visited);
            }
            visited.get(node).neighbors.add(visited.get(n));
        }
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}