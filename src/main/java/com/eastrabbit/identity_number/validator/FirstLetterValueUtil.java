package com.eastrabbit.identity_number.validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class FirstLetterValueUtil {

    private static final Map<String, Integer> FIRST_LETTER_MAP;
    private static final Map<String, Integer> FIRST_LETTER_VALUE_MAP;

    static {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 11);
        map.put("C", 12);
        map.put("D", 13);
        map.put("E", 14);
        map.put("F", 15);
        map.put("G", 16);
        map.put("H", 17);
        map.put("I", 34);
        map.put("J", 18);
        map.put("K", 19);
        map.put("L", 20);
        map.put("M", 21);
        map.put("N", 22);
        map.put("O", 35);
        map.put("P", 23);
        map.put("Q", 24);
        map.put("R", 25);
        map.put("S", 26);
        map.put("T", 27);
        map.put("U", 28);
        map.put("V", 29);
        map.put("W", 32);
        map.put("X", 30);
        map.put("Y", 31);
        map.put("Z", 33);
        FIRST_LETTER_MAP = Collections.unmodifiableMap(map);


        Map<String, Integer> valueMap = new HashMap<>();
        valueMap.put("A", getEnglishValue("A"));
        valueMap.put("B", getEnglishValue("B"));
        valueMap.put("C", getEnglishValue("C"));
        valueMap.put("D", getEnglishValue("D"));
        valueMap.put("E", getEnglishValue("E"));
        valueMap.put("F", getEnglishValue("F"));
        valueMap.put("G", getEnglishValue("G"));
        valueMap.put("H", getEnglishValue("H"));
        valueMap.put("I", getEnglishValue("I"));
        valueMap.put("J", getEnglishValue("J"));
        valueMap.put("K", getEnglishValue("K"));
        valueMap.put("L", getEnglishValue("L"));
        valueMap.put("M", getEnglishValue("M"));
        valueMap.put("N", getEnglishValue("N"));
        valueMap.put("O", getEnglishValue("O"));
        valueMap.put("P", getEnglishValue("P"));
        valueMap.put("Q", getEnglishValue("Q"));
        valueMap.put("R", getEnglishValue("R"));
        valueMap.put("S", getEnglishValue("S"));
        valueMap.put("T", getEnglishValue("T"));
        valueMap.put("U", getEnglishValue("U"));
        valueMap.put("V", getEnglishValue("V"));
        valueMap.put("W", getEnglishValue("W"));
        valueMap.put("X", getEnglishValue("X"));
        valueMap.put("Y", getEnglishValue("Y"));
        valueMap.put("Z", getEnglishValue("Z"));

        FIRST_LETTER_VALUE_MAP = Collections.unmodifiableMap(valueMap);
    }


    private static Integer getEnglishValue(String firstUpperCaseEnglish) {
        int englishValue = FIRST_LETTER_MAP.get(firstUpperCaseEnglish);
        int tensDigit = englishValue / 10;
        int onesDigit = englishValue % 10;
        return (tensDigit + (onesDigit * 9)) % 10;
    }

    static Integer getFirstLetterValue(String firstLetter) {
        return FIRST_LETTER_VALUE_MAP.get(firstLetter);
    }

}
