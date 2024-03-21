package com.eastrabbit.taiwannationalidentitynumber.validator;

import java.util.regex.Pattern;

class NationalIdentityNumberRegexCheckUtil {
    private static final String REGEX = "[A-Z][12]\\d{8}";
    private static final Pattern PATTERN = Pattern.compile(REGEX);
    static boolean validFormat(String taiwanIdentityNumber) {
        return PATTERN.matcher(taiwanIdentityNumber).matches();
    }
}
