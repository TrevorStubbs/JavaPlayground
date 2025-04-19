package org.example.geeksforgeeks;

public class BinarySearch {
    public static boolean binarySearch(int[] inputArray, int key) {
        int low = 0;
        int high = inputArray.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(inputArray[mid] == key) {
                return true;
            }

            if (inputArray[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return  false;
    }

    public static boolean binarySearchRec(int[] inputArray, int key) {
        int index = binarySearchRec(inputArray, 0, inputArray.length - 1, key);

        return index != -1;
    }


    private static int binarySearchRec(int[] inputArray, int low, int high, int key) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (inputArray[mid] == key) {
                return mid;
            }

            if(inputArray[mid] > key) {
                return binarySearchRec(inputArray, low, mid - 1, key);
            }

            return binarySearchRec(inputArray, mid + 1, high, key);
        }

        return -1;
    }
}
