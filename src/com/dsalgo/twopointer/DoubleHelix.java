package com.dsalgo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DoubleHelix {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        ArrayList<String> data =  new ArrayList<>();

        while(sc.hasNext()) {
            String line1 = sc.nextLine();
            if (line1.equals("0")) break;
            data.add(line1);
        }
        while(data.size() != 0){
            String line1 = data.remove(0);
            Integer[] arr1 = Arrays.stream(line1.split("\\s+")).map(s-> s.trim()).map(Integer::parseInt).toArray(Integer[]::new);
            String line2 = data.remove(0);
            Integer[] arr2 = Arrays.stream(line2.split("\\s+")).map(s-> s.trim()).map(Integer::parseInt).toArray(Integer[]::new);


            int p1 = 1;
            int p2 = 1;
            int s1= 0, s2= 0;
            int maxSum = 0;
            while(p1 < arr1.length && p2 < arr2.length){

                if(arr1[p1] < arr2[p2]){
                    s1 += arr1[p1];
                    p1++;
                }
                else if(arr1[p1] > arr2[p2]){
                    s2 += arr2[p2];
                    p2++;
                }
                else{
                    maxSum += Math.max(s1, s2) + arr1[p1];
                    p1++;
                    p2++;
                    s1=s2=0;

                }
            }
            while(p1 < arr1.length ){
                s1 += arr1[p1++];
            }
            while(p2 < arr2.length){
                s2 += arr2[p2++];
            }
            maxSum += Math.max(s1, s2);

            System.out.println(maxSum);
        }


    }
}
