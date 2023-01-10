package ru.ddark008.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small;
        int[] big;
        if (nums1.length < nums2.length){
            small = nums1;
            big = nums2;
        } else {
            small = nums2;
            big = nums1;
        }

        int[] dic = new int[1001];
        for (int j : small) {
            dic[j]++;
        }

        List<Integer> r = new ArrayList<>();
        for (int s : big) {
            if (dic[s] > 0) {
                dic[s]--;
                r.add(s);
            }
        }
        return r.stream().mapToInt(i -> i).toArray();
    }

    //
    public int[] intersect2(int[] nums1, int[] nums2) {
        int[] dic = new int[1001];
        int[] r = new int[1001];

        for(int i: nums1){
            dic[i]++;
        }

        int c = 0;
        for(int j: nums2){
            if (dic[j]>0){
                dic[j]--;
                r[c++] = j;
            }
        }
        return Arrays.copyOf(r,c);
    }

    // O(n*log(n)+m*log(m)+min(n,m))
    public int[] intersect3sorted(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int c = 0;
        int[] r = new int[1001];

        int p1 = 0;
        int p2 = 0;

        while(p1<nums1.length && p2<nums2.length){
            if (nums1[p1] == nums2[p2]){
                r[c++] = nums1[p1];
                p1++;
                p2++;
            } else if (nums1[p1] < nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return Arrays.copyOf(r,c);
    }

    static int[] intersect4(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int c = 0;
        int[] r = new int[1001];

        int[] small = nums1.length < nums2.length ? nums1 : nums2;
        int[] big = nums1.length < nums2.length ? nums2 : nums1;

        //[0, 2, 2, 2, 3]
        //[1, 2, 2, 4]

        // i = 3

        for(int i = 0; i<small.length; i++){
            int s = small[i];                       // 2
            int jL = Lbin(s, big);                  // 1
            if (s == big[jL]){
                int iR = Rbin(s, small);            //2
                int jR = Rbin(s, big);              //3
                int count = Math.min(jR-jL, iR-i);  // 3-1=2 2-1=1  1
                while(count >= 0){
                    r[c++] = s;
                    count--;
                }
                i = iR;
            }
        }
        return Arrays.copyOf(r,c);
    }

    static int Lbin(int s, int[] n){
        int l = 0;
        int r = n.length-1;
        //[1,6, 7] 6
        // 0 2
        // 0 1
        // 1 1
        while(l<r){
            int m = (l+r)/2; //0
            if (n[m]>=s){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    static int Rbin(int s, int[] n){
        int l = 0;
        int r = n.length-1;
        while(l<r){
            int m = (l+r+1)/2;
            if (n[m]<=s){
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect4(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
