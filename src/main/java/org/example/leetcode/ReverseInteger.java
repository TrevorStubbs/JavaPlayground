package org.example.leetcode;

public class ReverseInteger {
    public static int reverse(int x) {
        String intString = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        sb.append(x);

        if(sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            sb.append('-');
        }

        sb.reverse();

        try {
            return Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }

    }
}
