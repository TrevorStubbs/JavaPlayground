package org.example.leetcode;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        StringBuilder sb = new StringBuilder();

        if (s.isEmpty()) {
            return true;
        }

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sb.append(s.charAt(sIndex));
                sIndex++;
            }
            tIndex++;
        }

        return sb.toString().equals(s);
    }

    public static boolean isSubsequenceRegex(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }

        String result = t.replaceAll("[^" + s + "]", "");

        return result.contains(s);
    }

}
