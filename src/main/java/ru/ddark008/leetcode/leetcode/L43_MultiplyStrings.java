package ru.ddark008.leetcode.leetcode;

public class L43_MultiplyStrings {
    // "123" "99"
    static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] r = new int[num1.length()+num2.length()-1];
        for(int i = num1.length()-1; i>=0; i--){
            for(int j=num2.length()-1; j>=0; j--){
                r[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        for (int i = r.length - 1; i > 0; i--) {
            r[i - 1] += r[i] / 10;
            r[i] = r[i]%10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i: r) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123", "99"));
    }
}
