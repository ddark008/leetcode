package ru.ddark008.leetcode.leetcode;

/**
 * CPU: O(1)
 * MEM: O(1)
 */
public class L69_Sqrt_x {
    public static int mySqrt(int x) { // 4
        if (x == 0 || x == 1) return x;
        long l = 0;
        long r = x / 2; // 2
        while (l < r) {
            long m = (l + r + 1) / 2; // 3
            if (m * m > x) { // 9 <= 4
                r = m-1; // l = 1
            } else {
                l = m; // r = 2 - 1;
            }
        }
        return (int) l;
    }
}
