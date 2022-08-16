package com.dsalgo.graph.onstrings;

import java.util.*;

/**
 * Problem Link: https://leetcode.com/problems/word-ladder/
 * Code to solve Word ladder using BFS
 * Time: O(26*N*N*W) - 26*N(to generate combination from word), N for string comparison and W is number of words
 * Approach:
 * - Maintain queue for BFS Traversal
 * - add all the words in the set
 * - check if the endWord is present in the set or not if not then return 0 as we can't transform
 * - add the beginWord in the queue and maintain the depth variable
 *    - get the size of the queue
 *    - increment the depth at each level
 *    - iterate over the size of tree at each depth
 *      - pick the first element in the queue
 *      - run loop for its length
 *          - maintain char array for the element
 *          - run loop for a-z and change letters at each position to generate strings
 *              - skip is string is equal to the current string from queue
 *              - return depth + 1 if string is equal to endWord
 *              - else if string present in the set then add it in queue and remove from set
 */
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set =  new HashSet(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> queue= new LinkedList();
        queue.add(beginWord);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0;i<size;i++){
                String curr = queue.poll();
                for(int x=0;x<curr.length();x++){
                    char[] currChar = curr.toCharArray();

                    for(char l='a';l<='z';l++){
                        currChar[x] = l;
                        if(Arrays.compare(currChar,curr.toCharArray()) == 0) continue;
                        if(Arrays.compare(currChar,endWord.toCharArray()) == 0) return depth+1;
                        if(set.contains(new String(currChar))){
                            queue.add(new String(currChar));
                            set.remove(new String(currChar));
                        }
                    }
                }
            }
        }
        return 0;
    }
}