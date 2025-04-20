package org.example.geeksforgeeks.hashing;

import java.util.HashSet;
import java.util.Set;

public class SubsetOfAnotherArray {
    public static boolean subsetOfAnotherArray(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();

        for (int num : array1) {
            set.add(num);
        }

        for (int num : array2){
            if(!set.contains(num)) {
                return false;
            }
        }

        return true;
    }
}
