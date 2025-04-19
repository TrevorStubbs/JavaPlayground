package org.example;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedArrays {
    public static List<Integer> merge(List<Integer> inputListOne, List<Integer> inputListTwo) {
        int indexOne = 0;
        int indexTwo = 0;
        List<Integer> answer = new ArrayList<>();

        while (indexOne < inputListOne.size() && indexTwo < inputListTwo.size()) {
            System.out.printf("index one: %s index two: %s", indexOne, indexTwo);
            if (inputListOne.get(indexOne) < inputListTwo.get(indexTwo)) {
                answer.add(inputListOne.get(indexOne));
                indexOne++;
            } else {
                answer.add(inputListTwo.get(indexTwo));
                indexTwo++;
            }
            System.out.println();
        }

        while (indexOne < inputListOne.size()) {
            answer.add(inputListOne.get(indexOne));
            indexOne++;
        }

        while (indexTwo < inputListTwo.size()) {
            answer.add(inputListTwo.get(indexTwo));
            indexTwo++;
        }

        return answer;
    }
}
