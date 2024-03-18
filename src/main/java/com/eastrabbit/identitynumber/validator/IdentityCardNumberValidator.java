package com.eastrabbit.identitynumber.validator;

import com.eastrabbit.identitynumber.exception.IdentityCardNumberException;

public class IdentityCardNumberValidator {

    private static final Integer LAST_ID_INDEX = 9;

    public static void valid(final String identityCardNumber) throws IdentityCardNumberException {
        boolean result = IdentityCardNumberRegexCheckUtil.validFormat(identityCardNumber);
        if (!result) {
            throw new IdentityCardNumberException("Wrong format");
        }
        //將身份證字號轉為char[]
        final char[] identityNumberChars = identityCardNumber.toCharArray();
        //取得身份證字號最後一位數
        final int lastIdentityNumber = Character.getNumericValue(identityNumberChars[LAST_ID_INDEX]);
        //計算出檢查碼
        final int checkNumber = getCheckNumber(identityNumberChars);
        //檢查碼應該和身分證最後一碼相同
        if (!(checkNumber == lastIdentityNumber)) {
            throw new IdentityCardNumberException("Invalid identity card number.");
        }
    }

    private static int getCheckNumber(char[] identityNumberChars) {
        // 取得身份證字號第一個字母
        final String firstLetter = String.valueOf(identityNumberChars[0]);
        // 取得第一個字母對應的數字
        int sum = IdentityCardNumberFirstLetterValueMapper.getFirstLetterValue(firstLetter);
        // 開始計算並加總
        sum += Character.getNumericValue(identityNumberChars[1]) * 8;
        sum += Character.getNumericValue(identityNumberChars[2]) * 7;
        sum += Character.getNumericValue(identityNumberChars[3]) * 6;
        sum += Character.getNumericValue(identityNumberChars[4]) * 5;
        sum += Character.getNumericValue(identityNumberChars[5]) * 4;
        sum += Character.getNumericValue(identityNumberChars[6]) * 3;
        sum += Character.getNumericValue(identityNumberChars[7]) * 2;
        sum += Character.getNumericValue(identityNumberChars[8]);
        //除10取餘數
        int sumMod10 = sum % 10;
        if (sumMod10 == 0) {
            // 餘數是0時，檢查碼為0
            return 0;
        } else {
            // 餘數不是0時，檢查碼 = 10 - 餘數
            return (10 - sumMod10);
        }
    }

}
