package com.dsalgo.trie;

class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    boolean contains(char c){
        return get(c) != null;
    }

    Node get(char c){
        return links[c - 'a'];
    }

    void insert(char c, Node node){
        links[c-'a'] = node;

    }

    void end(){
        flag = true;
    }

    boolean isEnd(){
        return flag;
    }
}

public class ImplementTrie1 {
    Node root ;
    public ImplementTrie1() {
        root  =  new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            if(!node.contains(c)){
                node.insert(c, new Node());
            }
            node = node.get(c);
        }
        node.end();
    }

    public boolean search(String word) {
        Node node=  root;
        for(char c: word.toCharArray()){
            if(!node.contains(c)) return false;
            node = node.get(c);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node=  root;
        for(char c: prefix.toCharArray()){
            if(!node.contains(c)) return false;
            node = node.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */