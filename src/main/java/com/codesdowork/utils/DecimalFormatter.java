package com.codesdowork.utils;

import java.text.DecimalFormat;

public class DecimalFormatter {

    private final DecimalFormat decimalFormat;

    public DecimalFormatter(int decimals) {
        decimalFormat = new DecimalFormat("0" + (decimals > 0 ? "." : "") + "0".repeat(Math.max(0, decimals)));
    }

    public String format(double number) {
        String result = decimalFormat.format(number);

        for(char lastChar = result.charAt(result.length() - 1);
            !hasNumbersOnly(result) && lastChar < 49 || lastChar > 57;
            lastChar = result.charAt(result.length() - 1)) {
            result = result.substring(0, result.length() - 1);
        }

        return result;
    }

    private boolean hasNumbersOnly(String valueString) {
        for(char c : valueString.toCharArray()) {
            if(c < 48 || c > 57) {
                return false;
            }
        }
        return true;
    }
}