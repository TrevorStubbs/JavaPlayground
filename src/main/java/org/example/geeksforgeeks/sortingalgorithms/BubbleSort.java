package org.example.geeksforgeeks.sortingalgorithms;

public class BubbleSort {
    public static int[] bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) { // index i is not use for anything other than to limit inner loop
            for (int j = 0; j < length - 1 - i;
                 j++) { // length - 1 - i prevents from going outside the bounds of the array
                if (array[j] > array[j + 1]) { // if array at index is greater than the array at the next index.
                    // this acts like reversing a linked list
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }

    public static int[] bubbleSortEarlyExit(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            boolean swapped = false; // start this loop with swapped false.

            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // swap happened so set the flag to true
                }
            }

            if (!swapped) { // No swap happened so array is sorted
                return array; // so return early
            }
        }

        return array;
    }

    public static int[] bubbleSortRec(int[] array) {
        return bubbleSortRec(array, array.length, false);
    }

    private static int[] bubbleSortRec(int[] array, int size, boolean flag) {
        if (size == 1) {
            return array;
        }

        flag = false;

        for (int i = 0; i < size - 1; i++) {
            if(array[i] > array[i+1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
                flag = true;
            }
        }

        if(!flag) {
            return array;
        }

        return bubbleSortRec(array, size - 1, flag);
    }
}
