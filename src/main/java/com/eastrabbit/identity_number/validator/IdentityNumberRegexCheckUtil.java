package com.eastrabbit.identity_number.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class IdentityNumberRegexCheckUtil {
    private static final String regex = "[A-Z][12]\\d{8}";
    private static final Pattern pattern = Pattern.compile(regex);

    static boolean isLegal(String taiwanIdentityNumber) {
        Matcher matcher = pattern.matcher(taiwanIdentityNumber);
        return matcher.matches();
    }
}
