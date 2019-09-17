import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        TreeMap<Long, Long> map = new TreeMap<>();

        int count =0 ;
        while (count < n) {
            map.put(sc.nextLong(), sc.nextLong());
            count++;
        }

        long bufNum = 0;
        long maxBuf = Long.MIN_VALUE;
        long lastTime = 0;
        while (!map.isEmpty()) {
            long oldTime = map.firstKey();
            long oldTasks = map.firstEntry().getValue();
            map.pollFirstEntry();
            long curTime = map.firstKey();
            long curTasks = map.firstEntry().getValue();
            if (curTime - oldTime >= oldTasks) {
                bufNum += curTasks;
            } else {
                bufNum += oldTasks - (curTime - oldTime) + curTasks;
            }
            lastTime=curTime;
            maxBuf = Math.max(maxBuf, bufNum);
//            map.pollFirstEntry();
        }
        if (bufNum == 0) {
            System.out.println(lastTime + 1 + " " + maxBuf);
        } else {
            System.out.println(lastTime+bufNum+" "+maxBuf);
        }
    }


}