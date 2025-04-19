package org.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] numbers) {
        List<String> output = new ArrayList<>();

        if (numbers == null || numbers.length == 0) { // fail case
            return output;
        }

        int start = numbers[0];
        String joiner = "->";

        for (int index = 1; index <= numbers.length; index++) { // <= since we are looking back for the index
            // if index is length this is the last iteration of looking back OR
            // if this number is not equal to the last number plus 1 then make the new string
            if (index == numbers.length || numbers[index] != numbers[index - 1] + 1) {
                // is the start and the end the same?
                if(start == numbers[index - 1]) {
                    // output only 1 string
                    output.add(String.valueOf(numbers[index - 1]));
                } else {
                    // else join start with numbers at index 1
                    StringBuilder sb = new StringBuilder();
                    sb.append(start);
                    sb.append(joiner);
                    sb.append(numbers[index-1]);
                    output.add(sb.toString());
                }

                if (index < numbers.length) {
                    start = numbers[index];
                }
            }
        }

        return output;
    }
}
