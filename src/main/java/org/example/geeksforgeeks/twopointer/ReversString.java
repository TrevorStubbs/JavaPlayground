package org.example.geeksforgeeks.twopointer;

public class ReversString {
    public static char[] reverseString(char[] characters) {
        int left = 0;
        int right = characters.length - 1;

        while (left<=right) {
            char leftTemp = characters[left];
            char rightTemp = characters[right];
            characters[left] = rightTemp;
            characters[right] = leftTemp;

            left++;
            right--;
        }

        return characters;
    }
}
