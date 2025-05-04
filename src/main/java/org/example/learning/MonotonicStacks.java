package org.example.learning;

import java.util.Stack;

public class MonotonicStacks {

    /*
    can be increasing (ie lower on the bottom)
    or decreasing (higher on the bottom)
     */
    public static int[] nextGreaterElement(int[] numbers) {
        int[] output = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            // remove all elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }

            output[i] = stack.empty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return output;
    }

    public static int[] nextSmallerElement(int[] numbers) {
        int[] output = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && stack.peek() >= numbers[i]) {
                stack.pop();
            }

            output[i] = stack.empty() ? -1 : stack.peek();
            stack.push(numbers[i]);
        }

        return output;
    }

    // if not good then set 0;


    public static int[] dailyTemperatures(int[] temps) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temps.length];

        for (int i = 0; i < temps.length; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay;
            }
            stack.push(i);
        }

        return answer;
    }
}
