package com.dsalgo.arrays;

/**
 * Problem Link: https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1
 */
class RearrangePosNeg {
    void rearrange(int arr[], int n) {
        // code here
        int wrongId = -1;
        for(int i=0;i<n;i++){
            if(wrongId != -1){
                if(arr[wrongId] >=0 && arr[i] < 0 || arr[wrongId] < 0 && arr[i] >=0 ){
                    rightRotate(arr, wrongId, i);
                    if(i - wrongId >= 2) wrongId+=2;
                    else wrongId = -1;
                }
            }
            else{
                if(arr[i] >= 0 && i%2 ==1 || arr[i] < 0 && i%2==0 ){
                    wrongId = i;
                }
            }
        }
    }

    private void rightRotate(int arr[], int from, int to){
        int temp = arr[to];
        for(int i=to;i>from;i--){
            arr[i] = arr[i-1];
        }
        arr[from] = temp;
    }
}