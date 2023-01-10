package ru.ddark008.leetcode.leetcode;

public class L215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = transform(nums, l, r);
            if (m == index) return nums[m];
            if (m > index) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public int transform(int[] m, int l, int r) {
        int w = l;
        while (l != r) {
            if (m[l] < m[r]) {
                swap(m, w, l);
                w++;
            }
            l++;
        }
        swap(m, w, r);
        return w;
    }

    public void swap(int[] m, int p1, int p2) {
        int tmp = m[p1];
        m[p1] = m[p2];
        m[p2] = tmp;
    }
}
