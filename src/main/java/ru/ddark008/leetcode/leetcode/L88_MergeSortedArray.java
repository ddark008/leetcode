package ru.ddark008.leetcode.leetcode;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class L88_MergeSortedArray {
// {1, 2, 3, 0, 0, 0} {5, 6, 7}
// {5, 6, 7, 0, 0, 0} {1, 2, 3}
// {1}, {}
// {0}, {1}

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1; //-1
            int j = n-1; //0
            int k = m+n-1; // 0
            while(i >= 0 || j >= 0){
                if (i >= 0 && (j < 0 || nums1[i]>nums2[j])){
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
        }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        m--;
        n--;
        while(m >= 0 && n >= 0){
            nums1[i--] = (nums1[m]> nums2[n]) ? nums1[m--]: nums2[n--];
        }
        while (n >=0){
            nums1[i--] = nums2[n--];
        }
    }
}
