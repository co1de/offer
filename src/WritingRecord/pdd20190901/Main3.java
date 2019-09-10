package WritingRecord.pdd20190901;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
//        long[][] arr = new long[n+1][m+1];
//        long[] data = new long[(n+1)*(m+1)];
        ArrayList<Long> data2 = new ArrayList<>();
        //init
        int p=0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
//                arr[i][j] = i * j;
//                data[p++]=i*j;
                data2.add((long) (i * j));
            }
        }

//        List<Long> list = new ArrayList<>();
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                list.add(arr[i][j]);
//            }
//        }
//        Collections.sort(list,Collections.reverseOrder());
//        Arrays.sort(data);
        Collections.sort(data2,Collections.reverseOrder());
//        ArrayList<Long> list = new ArrayList<>();
//        for (int i = data.length - 1; i >= 0; i--) {
//            list.add(data[i]);
//        }
        long count=1;
        for (Long each : data2) {
            if (count == k) {
                System.out.println(each);
                return;
            }else count++;
        }
    }
}
