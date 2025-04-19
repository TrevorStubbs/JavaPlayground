package org.example.euler;

public class LargestPalindromeProduct {
    public static int findLargestPalindromeProductOfDigits(int numOfDigits) {
        int startingNumber;

        for (int i = numOfDigits; i > 0; i--) {
            for (int j = numOfDigits; j > 0; j--) {
                if (isPalindrome(i * j))
                    return i * j;
            }
        }


        return 0;
    }

    public static boolean isPalindrome(Integer number) {
        String first = number.toString();
        String second = new StringBuffer(first).reverse().toString();

        return first.equals(second);
    }
}
