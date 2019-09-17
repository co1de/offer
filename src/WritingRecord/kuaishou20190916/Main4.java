package WritingRecord.kuaishou20190916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        int count = 0;
        while (count < n) {
            arr[count++] = sc.nextLong();
        }
        System.out.println(longestSequence(arr));
    }

    public static long longestSequence(long[] arr) {
        Arrays.sort(arr);
        long[][] dp = new long[arr.length + 1][arr.length + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],1L);
        }
        int dis = 1;
        long longest = 1;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j <= i-1 ; j++) {
                dis = (int) (arr[i] - arr[j]);
                dp[i][dis] = dp[j][dis] + 1;
                longest = Math.max(longest, dp[i][dis]);
            }
        }
        return longest;
    }
}
