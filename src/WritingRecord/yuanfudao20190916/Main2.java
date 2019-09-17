package WritingRecord.yuanfudao20190916;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        long[] arr = new long[n];
        int count = 0;
        while (count < n) {
            arr[count++] = sc.nextLong();
        }
        long ret = Long.MIN_VALUE;
        int start=0;
        int curPos = 0;
        long sum = arr[curPos];
        while (curPos < arr.length) {
            if (sum <= s) {
                curPos++;
                if (curPos < n) {
                    sum += arr[curPos];
                    ret = Math.max(ret, curPos - start);
                }
            } else {
                sum -= arr[start];
                start++;
                ret = Math.max(ret, curPos - start);
            }
        }
        System.out.println(ret);
    }
}
