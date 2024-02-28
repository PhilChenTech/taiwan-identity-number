package com.eastrabbit.identity_number.validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FirstLetterValueUtil {

    public static final Map<String, Integer> FIRST_LETTER_VALUE_MAP;

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 0);
        map.put("C", 9);
        map.put("D", 8);
        map.put("E", 7);
        map.put("F", 6);
        map.put("G", 5);
        map.put("H", 4);
        map.put("I", 9);
        map.put("J", 3);
        map.put("K", 2);
        map.put("L", 2);
        map.put("M", 1);
        map.put("N", 0);
        map.put("O", 8);
        map.put("P", 9);
        map.put("Q", 8);
        map.put("R", 7);
        map.put("S", 6);
        map.put("T", 5);
        map.put("U", 4);
        map.put("V", 3);
        map.put("W", 1);
        map.put("X", 3);
        map.put("Y", 2);
        map.put("Z", 0);
        FIRST_LETTER_VALUE_MAP = Collections.unmodifiableMap(map);
    }

    public static Integer getFirstLetterValue(String firstLetter) {
        return FIRST_LETTER_VALUE_MAP.get(firstLetter);
    }

}
