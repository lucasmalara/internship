package com.internship.adb.busses.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StringValidator {

    public static boolean validateEngine(String s) {
        return s.matches("^((?i)\\bdiesel\\b+?|(?i)\\belectric\\b+?)*$");
    }

    public static boolean validateNonNegativeNumber(String s) {
        return s.matches("^\\d+$");
    }

    public static boolean validateBrand(String s) {
        return s.matches("^(?!.*[_\\r\\n])[a-zA-Z]([-a-zA-Z ]*[a-zA-Z])?$");
    }

    public static boolean validateModel(String s) {
        return s.matches("^(?!.*[_\\r\\n])\\w([-\\w ]*\\w)?$");
    }
}