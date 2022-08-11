package com.dsalgo.recursion;

public class LetterCasePermutation {

        public static void main(String[] args) {
            String input = "a1b1";
            String output = "";

            findPermutation(input, output);

        }

        static void findPermutation(String input, String output){

            if(input.length() == 0){
                System.out.println(output);
                return;
            }
            if(Character.isDigit(input.charAt(0))) {
                findPermutation(input.substring(1, input.length()), output + (input.charAt(0) + ""));
                return;
            }
            findPermutation(input.substring(1, input.length()), output+(input.charAt(0)+"").toLowerCase());
            findPermutation(input.substring(1, input.length()), output+(input.charAt(0)+"").toUpperCase());

        }
}
