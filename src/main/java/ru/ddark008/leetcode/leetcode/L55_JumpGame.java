package ru.ddark008.leetcode.leetcode;

public class L55_JumpGame {
    // 1. Состояние динамики - посетили ячейку или нет
    // 2. База динамики - ноль - не посетили
    // 3. Переход - если ячейка посещена, то отмечаем ячекй на которую она указывает
    // 4. Порядок обхода - сслева на право
    // 5. Ответ - в послденей ячейке dp
    // [0, 1, 2,]
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max_jump = 0; //2
        for (int i=0; i < nums.length; i++){
            if (dp[i] > 0 && i+nums[i] > max_jump){ //4
                int j = i; //1
                while(j < dp.length && j<= i+nums[i]){
                    dp[j] = 1;
                    max_jump = j;
                    j++;
                }
            }
        }
        return dp[dp.length-1] == 1;
    }

    // 1. Состояние динамики - посетили ячейку или нет
    // 2. База динамики - ноль - не посетили
    // 3. Переход - если ячейка посещена, то отмечаем ячекй на которую она указывает
    // 4. Порядок обхода - сслева на право
    // 5. Ответ - в послденей ячейке dp
    // [0, 1, 2,]
    public boolean canJump2(int[] nums) {
        int max_jump = 0; //2
        for (int i=0; i < nums.length; i++){
            if (i <= max_jump){ //4
                max_jump = Math.max(max_jump, i+nums[i]);
            }
        }
        return max_jump >= nums.length-1;
    }
}
