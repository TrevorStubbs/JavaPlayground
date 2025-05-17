package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumUnSorted {
    public static int[] TwoSumUnSorted(int[] input, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < input.length; i++){
            if(map.get(input[i]) == null) {
                List<Integer> list = new ArrayList<>(input[i]);
                map.put(input[i], list);
            } else {
                List<Integer> indexList = map.get(input[i]);
                indexList.add(i);
                map.put(input[i], indexList);
            }
        }

        Arrays.sort(input);

        int left = 0;
        int right = input.length-1;
        int[] output = new int[2];

        while(left <= right) {
            int number = input[left] + input[right];

            if(target == number) {
                List<Integer> leftNumbers = map.get(input[left]);
                Integer leftIndex = leftNumbers.get(leftNumbers.size() - 1);
                leftNumbers.remove(leftIndex);
                map.put(input[left], leftNumbers);
                output[0] = leftIndex;

                List<Integer> rightNumbers = map.get(input[right]);
                Integer rightIndex = rightNumbers.get(rightNumbers.size() - 1);
                map.put(input[right], rightNumbers);
                output[1] = rightIndex;
                return output;
            }

            if(target < number) {
                right--;
            } else {
                left++;
            }
        }

        return output;
    }

    public static int[] TwoSumUnSortedFaster(int[] input, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < input.length; i++) {
            int check = target - input[i];
            if(map.containsKey(check)) {
                return new int[] {map.get(check), i};
            } else {
                map.put(input[i], i);
            }
        }

        return null;
    }
}
