package com.dsalgo.trie;

class TrieNode{
    TrieNode[] links = new TrieNode[26];
    int endsWith=0;
    int countPrefix = 0;

    boolean contains(char ch){
        return get(ch) != null;
    }

    void insert(char ch, TrieNode TrieNode){
        links[ch - 'a'] = TrieNode;
    }

    TrieNode get(char ch){
        return links[ch - 'a'];
    }

    void endWord(){
        endsWith = endsWith +1;
    }

    int getEndsWith(){
        return endsWith;
    }

    int getCountPrefix(){
        return countPrefix;
    }

    void eraze(){
        countPrefix -= 1;
    }

    void delete(){
        endsWith -= 1;
    }
}

public class ImplementTrie2 {
    TrieNode root ;
    public ImplementTrie2() {
        // Write your code here.
        root =  new TrieNode();
    }

    public void insert(String word) {
        // Write your code here.
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.contains(ch)){
                curr.insert(ch, new TrieNode());
            }
            curr = curr.get(ch);
            curr.countPrefix+=1;
        }
        curr.endWord();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        TrieNode curr =  root;
        for(char ch : word.toCharArray()){
            if(!curr.contains(ch)) return 0;
            curr = curr.get(ch);
        }
        return curr.getEndsWith();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        TrieNode curr = root;
        for(char ch: word.toCharArray()){
            if(!curr.contains(ch)) return 0;
            curr = curr.get(ch);
        }
        return curr.getCountPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        TrieNode curr = root;
        if(countWordsEqualTo(word) <= 0) return;
        for(char ch: word.toCharArray()){
            curr = curr.get(ch);
            curr.eraze();
        }
        curr.delete();
    }
}
