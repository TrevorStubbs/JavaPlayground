package org.example.euler;

public class SmallestMultiple {
    public int smallestMult(int max) {
        int target = 1;
        while(target <= max) {
            for (int i = 1; i <= 10; i++) {
                if(target % i != 0){
                    continue;
                }

                return target;
            }

            target++;
        }

        return target;
    }

    // if any have a remainder move to the next number

}
