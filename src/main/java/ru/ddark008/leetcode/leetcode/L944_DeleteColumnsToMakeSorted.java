package ru.ddark008.leetcode.leetcode;

public class L944_DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int deleted = 0;
        for(int i=0; i<strs[0].length();i++){
            char prev = (char) 0;
            for (String str : strs) {
                char curr = str.charAt(i);
                if (prev > curr) {
                    deleted++;
                    break;
                } else {
                    prev = curr;
                }
            }
        }
        return deleted;
    }
}
