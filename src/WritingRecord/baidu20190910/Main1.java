package WritingRecord.baidu20190910;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        int count =0;
        while (count < n) {
            arr[count++]=sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                int temp = map.get(arr[i]);
                map.put(arr[i], ++temp);
            }
        }
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ret=ret+ entry.getValue()%2+(int)(entry.getValue()/2) ;
        }
        System.out.println(ret);
    }
}
