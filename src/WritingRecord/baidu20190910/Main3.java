package WritingRecord.baidu20190910;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    private static int[] yingshe={2,5,5,4,5,6,3,7,6};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        int count =0;
        while (count < m) {
            arr[count++]=sc.nextInt();
        }
        Arrays.sort(arr);
        int curHuo = 0;
        int retLength=0;

        for (int i = 0; i < arr.length; i++) {
            retLength = Math.max(retLength, n / yingshe[arr[i] - 1]);
        }
        int leastHuo = Integer.MAX_VALUE;
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
//            leastHuo = Math.min(leastHuo, yingshe[arr[i] - 1]);
            if (yingshe[arr[i] - 1] < leastHuo) {
                leastHuo = yingshe[arr[i]-1];
                p = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (curHuo < n) {
            curHuo = curHuo + yingshe[arr[p] - 1];
            sb.append(arr[p]);
        }
        int last = n - curHuo-yingshe[arr[p] - 1];
        int q = Integer.MIN_VALUE;
        int z = 0;
        for (int i = 0; i < arr.length; i++) {
            if (yingshe[arr[i] - 1] < last && yingshe[arr[i] - 1] > q) {
                q = yingshe[arr[i] - 1];
                z = i;
            }
        }
        sb.insert(sb.length() , arr[z]);
        System.out.println(sb.toString());
    }
}
