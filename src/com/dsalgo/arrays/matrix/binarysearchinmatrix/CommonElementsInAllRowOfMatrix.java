package com.dsalgo.arrays.matrix.binarysearchinmatrix;

import java.util.*;

/**
 * Problem Link: https://www.codingninjas.com/codestudio/problems/common-elements-present-in-all-rows-of-a-matrix_1118111
 */
public class CommonElementsInAllRowOfMatrix
{
    public static ArrayList<Integer> findCommonElements(ArrayList<ArrayList<Integer>> mat)
    {
        Map<Integer, Integer> countMap =  new HashMap();

        Set<Integer> output = new HashSet();
        for(int i=0;i<mat.size();i++){
            for(int j=0;j<mat.get(i).size();j++){
                if(i ==0 ){
                    countMap.put(mat.get(i).get(j), 0);
                }
                if(countMap.containsKey(mat.get(i).get(j))){
                    if(i == mat.size()-1 && countMap.get(mat.get(i).get(j)) == mat.size()-1){
                        output.add(mat.get(i).get(j));
                    }
                    else
                    if(countMap.get(mat.get(i).get(j)) == i)
                        countMap.put(mat.get(i).get(j), countMap.get(mat.get(i).get(j))+1);
                }

            }
        }
        return new ArrayList<Integer>(output);
    }
}
