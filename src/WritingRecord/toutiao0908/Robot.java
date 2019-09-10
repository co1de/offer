package WritingRecord.toutiao0908;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        int k=0;
        while (k < n) {
            arr[k++]=sc.nextInt();
        }
        int[] see = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            int prePos = i-1;
            while (prePos>=0 && arr[prePos] < arr[i]) {
                prePos--;
            }
            if (prePos >= 0) {
                see[prePos]++;
            }
        }
        int maxpos = 0;
        int countinueZero = 0;

        for (int i = 0; i < n; i++) {
            if (see[i] > see[maxpos]) {
                maxpos = i;
            }
            if (see[i]==0) countinueZero++;
        }
        if (countinueZero == n ) {
            System.out.println(0);
            return;
        }
        long ret = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == arr[maxpos]) {
                ret = arr[i];
                break;
            }
        }
        System.out.println(ret);
    }
}
