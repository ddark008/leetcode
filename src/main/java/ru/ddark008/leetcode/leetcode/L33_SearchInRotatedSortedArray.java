package ru.ddark008.leetcode.leetcode;

public class L33_SearchInRotatedSortedArray {
    static int search(int[] nums, int target) {
        //4,5,6,3
        //0 1 2 3
        int l = 0;
        int r = nums.length-1;
        // {1,0}
        // {0,1}
        while(l<r){
            int m = (l+r)/2; //2
            if (nums[m]>nums[r]){
                l = m+1; // 3
            } else {
                r = m;   // 3
            }
        }
        int l2,r2;
        if (target > nums[nums.length-1]){
            if (l == 0) return -1;
            l2=0;
            r2 = l-1;
        } else {
            l2=l;
            r2 = nums.length-1;
        }

        int s = Lbin(target, l2, r2, nums);
        if (nums[s] == target){
            return s;
        } else {
            return -1;
        }
    }

    static int Lbin(int s, int l, int r, int[] nums){
        // {1,0}
        // {0,1}
        while(l<r){
            int m = (l+r)/2; //2
            if (nums[m]>=s){
                r = m;   // 3
            } else {
                l = m+1; // 3
            }
        }
        return l;
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid])
                return mid;
            if (nums[mid] < nums[lo]) {
                // 6,7,0,1,2,3,4,5
                if (target < nums[mid] || target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                // 2,3,4,5,6,7,0,1
                if (target > nums[mid] || target < nums[lo])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{7,8,1,2,3,4,5,6},2));
        System.out.println(search(new int[]{4,5,6,7,0,1,2},0));
        System.out.println(search(new int[]{5,1,3},1));
    }
}
