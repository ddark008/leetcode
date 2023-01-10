package ru.ddark008.leetcode.leetcode;

import java.util.Arrays;

public class L443_StringCompression {
    static int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int w = 0;
        int r = 1;
        int count = 1;
        while(r < chars.length){
            if (chars[r] == chars[r-1]){
                count++;
            } else {
                chars[w++] = chars[r-1];
                if (count > 1){
                    w = intToChar(count, w, chars);
                }
                count = 1;
            }
            r++;
        }
        chars[w++] = chars[r-1];
        if (count > 1){
            w = intToChar(count, w, chars);
        }
        return w;
    }

    static int intToChar(int number, int w, char[] chars){
        int n = (int) Math.log10(number);
        for (int i=n; i >=0; i--){
            chars[w+i] = (char) ('0' + number%10);
            number /= 10;
        }
        return w + n + 1;
    }

    public static void main(String[] args) {
        char[] arr = "aabbEEWWWWWQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQQ".toCharArray();
        System.out.println(compress(arr) + "  " + Arrays.toString(arr));
    }
}
