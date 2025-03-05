package src.demo;

import java.util.*;


public class LongestIncreasingSubSeq {

    public static int run(int[] sequence) {
        int n = sequence.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Every element is a subsequence of length 1

        int maxLIS = 1;

        // Compute LIS for each index i
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }

        return maxLIS;
    }


    public static void main(String[] args) {
        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(run(arr));
    }

}
