package ru.ddark008.leetcode.leetcode;

public class L5_LongestPalindromicSubstring {
    static String longestPalindrome(String s) {
        int max_size = 0;
        int begin = 0;
        int end = 0;
        int p = 0;
        boolean bt = false;
        while (p<s.length()-1){ //1
            int pl, pr;
            if (!bt){
                pl = p-1; // 0
                pr = p+1; // 2
                bt = true;
            } else {
                pl = p; //1
                pr = p+1; //2
                p++;
                bt = false;
            }
            while(pl >= 0 && pr < s.length()){
                if (s.charAt(pl) != s.charAt(pr)){
                    break;
                }
                if (pr-pl+1 > max_size) {
                    max_size = pr-pl+1;
                    begin = pl;
                    end = pr;
                }
                pl--;
                pr++;
            }
        }
        return s.substring(begin, end+1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }
}
