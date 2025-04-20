package org.example;

import org.example.dailypractice.DailyPracticeApril20;
import org.example.geeksforgeeks.hashing.ContainsDisjoint;
import org.example.geeksforgeeks.hashing.SubsetOfAnotherArray;
import org.example.geeksforgeeks.sortingalgorithms.BubbleSort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        var thing = DailyPracticeApril20.printClosest(new int[] {1,2,3,4}, new int[] {5, 6, 7, 8, 9}, 7);

        // test commit
        System.out.println(Arrays.toString(thing));
    }
}