package org.example.geeksforgeeks;

public class TowerOfHanoi {
    public static void towerOfHanoi(int number, char fromRod, char toRod, char auxRod) {
        // base case
        if (number == 0) {
            return;
        }

        towerOfHanoi(number - 1, fromRod, auxRod, toRod);
        System.out.printf("Move disk %s from rod %s to rod %s%n", number, fromRod, toRod);
        towerOfHanoi(number - 1, auxRod, toRod, fromRod);
    }
}
