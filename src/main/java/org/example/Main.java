package org.example;

import org.example.geeksforgeeks.sortingalgorithms.BubbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var thing = BubbleSort.bubbleSortRec(new int[] {100, 2, 1, 6, 22, 10});

        System.out.println(Arrays.toString(thing));
    }
}