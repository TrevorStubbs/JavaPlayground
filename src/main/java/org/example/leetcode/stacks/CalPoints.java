package org.example.leetcode.stacks;

import java.util.Stack;

public class CalPoints {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i <operations.length; i++){
            String currentTarget = operations[i];

            if(currentTarget.equals("C")){
                stack.pop();
            } else if(currentTarget.equals("D")) {
                int target = stack.pop();
                int product = target * 2;

                stack.push(target);
                stack.push(product);
            } else if(currentTarget.equals("+")) {
                int top = stack.pop();
                int bottom = stack.pop();
                int sum = top + bottom;

                stack.push(bottom);
                stack.push(top);
                stack.push(sum);
            } else {
                stack.push(Integer.valueOf(currentTarget));
            }
        }

        int counter = 0;
        while(!stack.isEmpty()){
            counter += stack.pop();
        }

        return counter;
    }

    public static int calPointsSwitch(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String currentTarget : operations) {
            switch (currentTarget) {
                case "C" -> stack.pop();
                case "D" -> {
                    int target = stack.pop();
                    int product = target * 2;

                    stack.push(target);
                    stack.push(product);
                }
                case "+" -> {
                    int top = stack.pop();
                    int bottom = stack.pop();
                    int sum = top + bottom;

                    stack.push(bottom);
                    stack.push(top);
                    stack.push(sum);
                }
                default -> stack.push(Integer.valueOf(currentTarget));
            }
        }

        int counter = 0;
        while(!stack.isEmpty()){
            counter += stack.pop();
        }

        return counter;
    }
}
