package org.example.leetcode.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValidParentheses(String s) {
        if (s.length() <= 1 || s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c.equals('(') || c.equals('[') || c.equals('{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty() ||
                    (c.equals(')') && !stack.pop().equals('(')) ||
                    (c.equals('}') && !stack.pop().equals('{')) ||
                    (c.equals(']') && !stack.pop().equals('['))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static boolean isValidParenthesesMap(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for(char c: s.toCharArray()) {
            if(map.containsValue(c)){
                stack.push(c);
            } else if(map.containsKey(c)) {
                if(stack.isEmpty() || map.get(c) != stack.pop()){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
