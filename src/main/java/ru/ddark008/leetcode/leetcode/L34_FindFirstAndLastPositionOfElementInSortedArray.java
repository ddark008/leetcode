package ru.ddark008.leetcode.leetcode;

public class L34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1,-1};

        int l = Lbins(target, nums);

        if (nums[l] != target) return new int[]{-1,-1};

        int r = Rbins(target, nums);
        return new int[]{l,r};
    }
    private int Lbins(int s, int[] nums){
        int l = 0;
        int r = nums.length-1;
        // {0,1} - 1
        while(l<r){
            int m = (l+r)/2; // 0
            if (nums[m]>= s){
                r = m; // 1
            } else {
                l = m+1; // 0
            }
        }
        return l;
    }
    private int Rbins(int s, int[] nums){
        int l = 0;
        int r = nums.length-1;
        // {0,1} - 0
        while(l<r){
            int m = (l+r+1)/2; // 3
            if (nums[m]<= s){
                l = m; //2
            } else {
                r = m-1; // 3
            }
        }
        return l;
    }
}
