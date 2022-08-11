package com.dsalgo.recursion;

public class LetterCaseChangePermutation {

    public static void main(String[] args) {
        String input = "abc";
        String output = "";

        findPermutation(input, output);

    }

    static void findPermutation(String input, String output){

        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        findPermutation(input.substring(1, input.length()), output+(input.charAt(0)+""));
        findPermutation(input.substring(1, input.length()), output+(input.charAt(0)+"").toUpperCase());

    }


}
