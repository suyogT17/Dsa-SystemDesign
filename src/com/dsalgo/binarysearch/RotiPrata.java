package com.dsalgo.binarysearch;

import java.util.Scanner;

public class RotiPrata {

    /**
     * 3
     * 10
     * 4 1 2 3 4
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int numberOfPrata = sc.nextInt();
            int numberOfChefs = sc.nextInt();

            int[] ranks =  new int[numberOfChefs];
            for(int i=0;i< numberOfChefs;i++){
                ranks[i] = sc.nextInt();
            }

            System.out.println(printTimeRequired(ranks, numberOfPrata));
        }
    }

    private static int printTimeRequired(int[] ranks, int numberOfPrata){
        int left = 0;
        int right = (int) 1e8;
        int ans = 0;

        while(left <= right){
            int mid = left +  (right - left)/2;
            if(isPossible(ranks, mid, numberOfPrata)){
                ans = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return ans;
    }

    private static boolean isPossible(int[] ranks, int mid, int numberOfPrata) {
        int prata = 0;

        for(int i=0;i<ranks.length;i++) {
            int time = ranks[i];
            int j=2;
            while(time <= mid){
                prata++;
                time += ranks[i]*j++;
            }
        }
        return prata>=numberOfPrata;
    }
}
