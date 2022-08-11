package com.dsalgo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2 ,3 ,5,6,7));
        List<Integer> b = new ArrayList<>(Arrays.asList(1, 2 ,3));
        System.out.println(a.stream().filter(av -> !b.contains(av)).collect(Collectors.toList()));
    }

    private static void edit(int i) {

        i++;
        i++;
    }


}
