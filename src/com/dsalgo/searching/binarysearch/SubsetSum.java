package com.dsalgo.searching.binarysearch;

import java.util.*;

public class SubsetSum {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        int n  = sc.nextInt();
        int a =  sc.nextInt();
        int b =  sc.nextInt();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        List<Integer> l1 = findSubsets(arr, 0, arr.length/2);
        List<Integer> l2 = findSubsets(arr, arr.length/2+1 , arr.length-1);
        System.out.println(l1);
        System.out.println(l2);
        Collections.sort(l2);
        int count  = 0;
        for(int num: l1){
            int lower = findLowerBound(l2, a-num);
            int upper = findUpperBound(l2, b-num);
            System.out.println("("+lower+", "+upper+")");
            count+=(upper-lower);
        }
        System.out.println("count: "+count);
    }

    private static int findUpperBound(List<Integer> l2, int i) {
        int left = 0, right = l2.size()-1;
        while(left <= right){
            int mid =  left  + (right-left)/2;
            if(l2.get(mid) >= i){
                left = mid+1;
            }
            else right = mid-1;
        }

        return left;
    }

    private static int findLowerBound(List<Integer> l2, int i) {

        int left = 0, right = l2.size()-1;
        while(left <= right){
            int mid =  left  + (right-left)/2;
            if(l2.get(mid) <= i){
                right = mid-1;
            }
            else left = mid+1;
        }

        return left;
    }

    private static List<Integer> findSubsets(int[] arr, int i, int i1) {
        List<Integer> result = new ArrayList<>();
        result.add(new Integer(0));
        for(;i<=i1;i++){
            int n = result.size();
            for(int j=0;j<n;j++){
                int newSubSetSum = result.get(j) + arr[i];
                result.add(newSubSetSum);
            }
        }
        result.remove(0);
        return result;
    }
}


