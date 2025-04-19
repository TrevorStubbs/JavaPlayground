package org.example.euler;

public class EvenFibNumbers {
        public static long generateSumOfFib(long maxNumber) {
            long prev = 0;
            long current = 1;
            long output = 0;

            while(current < maxNumber) {
                long number = prev + current;
                if(number % 2 == 0)
                    output = output + number;

                prev = current;
                current = number;
            }

            return output;
        }
}
