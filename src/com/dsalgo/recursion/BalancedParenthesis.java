package com.dsalgo.recursion;

public class BalancedParenthesis {

    public static void main(String[] args) {
        int n = 3;
        generateParenthesis(n,n,"");
    }

    static void generateParenthesis(int left, int right, String output){
        if(left == 0 && right == 0){
            System.out.println(output);
            return;
        }
        if(left != 0){
            generateParenthesis(left-1, right, output+"(");
        }
        if(right > left) generateParenthesis(left, right-1, output + ")");



    }

}
