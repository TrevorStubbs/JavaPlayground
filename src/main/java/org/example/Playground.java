package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Playground {
    public static void playground() {
        String thing = "helloworldh";

        Map<Integer, Integer> map = new HashMap<>();
        map.merge(1, 1, Integer::sum);
        Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

        // indexOf gets the first index of the substring

        System.out.println(thing.indexOf("ell"));

        System.out.println(thing.substring(thing.indexOf("ell"), thing.indexOf("lo")));
    }
}
