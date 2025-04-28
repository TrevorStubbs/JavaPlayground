package org.example.geeksforgeeks.twopointer;

public class IsPalindrome {
    public static boolean isPalindromeSB(String string) {
        if (string.equals(" ")) {
            return true;
        }

        string = string.replaceAll("[\\s\\p{Punct}]+", "").toLowerCase();

        StringBuilder sb = new StringBuilder(string);
        sb.reverse();

        return string.contentEquals(sb);
    }
}
