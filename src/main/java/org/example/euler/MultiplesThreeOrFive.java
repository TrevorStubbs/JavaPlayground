package org.example.euler;

import com.sun.source.tree.BreakTree;

public class MultiplesThreeOrFive {
    private static Integer maxNumber = 1000;

    public static Integer getTotal(){
        int total = 0;

        for (int i = 0; i < maxNumber; i++){
            if(i % 5 == 0)
                total = total + i;

            if(i % 3 == 0)
                total = total +i;
        }

        return total;
    }

    public static Integer getTotalFaster() {
        return getMultOf(3) + getMultOf(5);
    }

    private static Integer getMultOf(Integer multNumber) {
        int total = 0;
        int current = 0;

        while(current < maxNumber){
            total = total + current;
            current = current + multNumber;
        }

        return total;
    }


}
