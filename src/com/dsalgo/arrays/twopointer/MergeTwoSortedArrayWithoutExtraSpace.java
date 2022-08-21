package com.dsalgo.arrays.twopointer;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 * Merge two sorted Array without extra space
 * Approaches:
 *  - Approach 1:
 *    Time: O(n*m)
 *      - using two pointer and re-arranging 2nd array after each swap
 *  - Approach 2:
 *    Time: O(m+n)
 *      - use initial gap as ceil((m+n)/2)
 *      - run till gap > 0
 *          - initialize i = 0 and j = gap
 *          - iterate over the array till j < (m+n)
 *              - swap array elements if arr1[i] is less than arr[j] (see conditions of swapping in code)
 *              - increment i and j
 *          - if gap == 1 then assign it to 0 else gap = ceil(gap/2) -> this is because ceil of 1/2 = 1 and it will loop infinitely
 */
class MergeTwoSortedArrayWithoutExtraSpace
{
    public static void merge1(long arr1[], long arr2[], int n, int m)
    {
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] > arr2[0]){
                //swapping elements and rearranging arr2
                long temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
                rearrange(arr2);
            }
        }
    }

    public static void rearrange(long arr2[]){
        long toCompare = arr2[0];
        boolean isSet = false;
        for(int j = 1;j<arr2.length;j++){
            if(arr2[j] < toCompare){
                arr2[j-1] = arr2[j];
            }
            else{
                arr2[j-1] = toCompare;
                isSet =true;
                break;
            }
        }
        if(!isSet) arr2[arr2.length-1] = toCompare;
    }

    public static void merge(long arr1[], long arr2[], int n, int m) {
        int gap = (int)Math.ceil((float)(n+m)/2.0f); // initital gap

        while(gap > 0){
            int i = 0;
            int j = gap;
            while(j < (n+m)){
                // check if i and j pointing to position in arr1
                if(i < n && j < n && arr1[i] > arr1[j]){
                    long temp = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp;
                }
                // check if i points position in arr1 and j int arr2
                else if(i < n && j >= n && arr1[i] > arr2[j-n]){
                    long temp = arr1[i];
                    arr1[i] = arr2[j-n];
                    arr2[j-n] = temp;
                }
                // check if i and j pointing to position in  arr2
                else if(i >= n && j >= n && arr2[i-n] > arr2[j-n]){
                    long temp = arr2[i-n];
                    arr2[i-n] = arr2[j-n];
                    arr2[j-n] = temp;
                }
                i++;
                j++;
            }
            if (gap == 1) {
                gap = 0;
            } else
                gap = (int)Math.ceil((float)gap/2.0f);
        }
    }
}
