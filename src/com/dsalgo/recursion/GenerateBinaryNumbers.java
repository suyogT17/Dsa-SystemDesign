package com.dsalgo.recursion;

public class GenerateBinaryNumbers {

    public static void main(String[] args) {

        int one = 0, zero = 0;
        int total = 4;
        solve(one, zero, total, "");


    }

    private static void solve(int one, int zero, int total, String s) {

        if(total == 0){
            System.out.println(s);
            return;
        }
        if(one == zero){
            solve(one+1, zero, total - 1, s+"1");
            return;
        }
        solve(one+1, zero, total - 1, s+"1");
        solve(one, zero+1, total - 1, s+"0");
    }
}
