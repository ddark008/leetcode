package ru.ddark008.leetcode.leetcode;

public class L279_PerfectSquares {
    public int numSquares(int n) {
        return createNodes(n);
    }
    public int createNodes(int n){
        if (n == 0) return 0;
        Integer minW = null;
        for(int i = 1; i<= Math.sqrt(n); i++){
            int w = createNodes(n-i*i);
            if (minW == null || w < minW){
                minW = w;
            }
        }
        return minW+1;
    }
    static int numSquares2(int n) {
        int m = (int) Math.sqrt(n);
        if (m*m == n) return 1;
        int[][] dp = new int[m][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 1){
                    dp[i-1][j] = j;
                } else {
                    int k = j/(i*i);
                    int diff = j-k*i*i;
                    dp[i-1][j] = Math.min(dp[i-2][j], k+ dp[i-2][diff]);
                }
            }
        }
        return dp[m-1][n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares2(13));
    }
}

