package ru.ddark008.leetcode.leetcode;

public class L14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        char[] prefix = strs[0].toCharArray();
        int max = prefix.length;
        for(int i=1; i<strs.length; i++){
            int j=0;
            max = Math.min(max, strs[i].length());
            while(j < max){
                if(prefix[j] == strs[i].charAt(j)){
                    j++;
                } else {
                    max=j;
                    break;
                }
            }
        }
        return String.valueOf(prefix,0,max);
    }
}
