package com.eastrabbit.identity_number.validator;

public class TaiwanIdentityValidator {

    public static boolean valid(final String taiwanIdentityNumber) {
        //確認格式正確
        if (!IdentityNumberRegexCheckUtil.isLegal(taiwanIdentityNumber)) {
            return false;
        }
        //將身份證字號轉為char[]
        char[] identityNumberChars = taiwanIdentityNumber.toCharArray();
        //取得身份證字號最後一位數
        int lastIdentityNumber = Character.getNumericValue(identityNumberChars[9]);
        int checkNumber;
        //計算出檢查碼
        try {
            checkNumber = getCheckNumber(identityNumberChars);
        } catch (Exception e) {
            return false;
        }
        //檢查碼應該和身分證最後一碼相同
        return checkNumber == lastIdentityNumber;
    }

    private static int getCheckNumber(char[] identityNumberChars) {
        // 取得身份證字號第一個字母
        final String firstLetter = String.valueOf(identityNumberChars[0]);
        // 取得第一個字母對應的數字
        int sum = FirstLetterValueUtil.getFirstLetterValue(firstLetter);
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
