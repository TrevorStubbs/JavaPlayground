package org.example.leetcode.prefix;

public class CommonLongestPrefix {
    public static String commonLongestPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        String prefix = strings[0];

        for (String s : strings) {
            while (s.indexOf(prefix) != 0) {
                // if prefix is not a substring of strings[i] then indexOf returns a -1
                // keep looping until we get a zero
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
