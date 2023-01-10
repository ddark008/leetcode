package ru.ddark008.leetcode.leetcode;

public class L125_ValidPalindrome {
    static boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return true;

        int a = 'a';
        int z = 'z';
        int A = 'A';
        int Z = 'Z';
        int zero = '0';
        int nine = '9';
        int diff = a-A;

        int start = 0;            // 1
        int end = s.length()-1;   // 1
        while(start<end){
            int ch_s = s.charAt(start);
            int ch_e = s.charAt(end);

            if (!((ch_s >= A && ch_s <= Z) ||  (ch_s >= a && ch_s <= z) || (ch_s >= zero && ch_s <= nine))){
                start++;
            } else if (!((ch_e >= A && ch_e <= Z) ||  (ch_e >= a && ch_e <= z) || (ch_e >= zero && ch_e <= nine))){
                end--;
            } else {
                if (ch_s >= A && ch_s <= Z) ch_s += diff;
                if (ch_e >= A && ch_e <= Z) ch_e += diff;
                if (ch_s != ch_e) return false;
                start++;
                end--;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.toLowerCase();

        int left = 0, right = s.length() - 1;
        while(left < right){

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;

            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }
}
