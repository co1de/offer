package WritingRecord.baidu20190910;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        while (count < n) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key, value);
            count++;
        }
//        map= (TreeMap<Integer, Integer>) map.descendingMap();
        int month = 0;
        int tmp = 0;
        int flag = 0;
        while (!map.isEmpty()) {
//            Map.Entry<Integer,Integer> entry = map.firstEntry();
            if ((tmp + map.lastEntry().getKey()) / m > 0) {
//                month = month + map.lastEntry().getKey() / m;
                flag = 0;
                tmp = tmp + map.lastKey();
                int curValue = map.lastEntry().getValue() - (tmp + map.lastEntry().getKey()) / m;
                if (curValue > 0) {
                    map.put(map.lastEntry().getKey(), curValue);
                } else {
                    map.remove(map.lastEntry().getKey());
                }
            } else {
//                month=month+map.firstEntry().getKey()/m;
                flag = 1;
                tmp = tmp + map.firstEntry().getKey();
                int curValue = map.firstEntry().getValue() - 1;
                if (curValue > 0) {
                    map.put(map.firstKey(), curValue);
                } else {
                    map.remove(map.firstKey());
                }
            }
            if (tmp >= m) {
                    month = month + (tmp) / m;
                    tmp = 0;
            }

        }
        System.out.println(month);
    }
}
