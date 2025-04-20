package org.example.geeksforgeeks.hashing;

import java.util.*;
import java.util.stream.*;

public class ContainsDisjoint {
    public static boolean containsDisjoint(int[] array1, int[] array2) {
        Set<Integer> set = Arrays.stream(array1).boxed().collect(Collectors.toSet());

        for (int num :array2) {
            if (set.contains(num))
                return false;
        }

        return true;
    }
}
