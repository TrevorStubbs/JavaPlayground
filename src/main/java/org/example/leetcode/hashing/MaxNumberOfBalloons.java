package org.example.leetcode.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloons {
    public static int maxNumberOfBalloons(String text) {
        String balloonChars = "balon";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : balloonChars.toCharArray()) {
            map.put(c, 0);
        }

        for(char c: text.toCharArray()) {
            if(map.get(c) != null) {
                map.merge(c, 1, Integer::sum);
            }
        }

        int counter = Integer.MAX_VALUE;

        for(char c: balloonChars.toCharArray()) {
            if(c == 'l' || c=='o') {
                Integer value = Math.floorDiv(map.get(c), 2);

                if(value < counter) {
                    counter = value;
                } else if (map.get(c) < counter) {
                    counter = map.get(c);
                }
            }
        }

        return counter;
    }
}

//Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
//
//You can use each character in text at most once. Return the maximum number of instances that can be formed.
//
//Example 1:
//
//Input: text = "nlaebolko"
//Output: 1
//Example 2:
//
//Input: text = "loonbalxballpoon"
//Output: 2
//Example 3:
//
//Input: text = "leetcode"
//Output: 0
//
//Constraints:
//    1 <= text.length <= 104
//text consists of lower case English letters only.

// My Notes:

// need to find the number of times balloon shows up. ball doenst count
// test min 1 max 10^4

// make a map of balloon with key char and val number
// run through all the chars of text and count the number of times letters from balloon appear.

// if any of the values are 0 then return 0.

// then find the lowest value that should be the answer.

// maybe have a counter var to do the final counting

// a, l, o are doubles. gotta check for doubles