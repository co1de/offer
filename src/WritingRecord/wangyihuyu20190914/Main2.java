package WritingRecord.wangyihuyu20190914;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int NUM = scanner.nextInt();
        ArrayList<Queue<Integer>> nextUser = new ArrayList<>();
        ArrayList<ArrayList<Integer>> oldUser = new ArrayList<>();
        int[] ans = new int[NUM + 1];
        int[] recoder = new int[NUM + 1];

        nextUser.add(new LinkedList<>());
        oldUser.add(new ArrayList<>());
        for (int i = 0; i < NUM; ++i) {
            int temp = scanner.nextInt();
            Queue<Integer> temq = new LinkedList<>();
            for (int j = 0; j < NUM; j++) {
                temq.offer(scanner.nextInt());
            }
            nextUser.add(temq);
        }

        for (int i = 0; i < NUM; ++i) {
            int temp = scanner.nextInt();
            ArrayList<Integer> temq = new ArrayList<>();
            for (int j = 0; j < NUM; j++) {
                temq.add(scanner.nextInt());
            }
            oldUser.add(temq);
        }

        boolean flag=false;
        while (true) {
            for (int i = 1; i <= NUM; i++) {
                if (ans[i] == 0) {
                    int temp = nextUser.get(i).poll();
                    if (recoder[temp] == 0) {
                        ans[i] = temp;
                        recoder[temp] = i;
                    } else {
                        int index_now = oldUser.get(temp).indexOf(i);
                        int index_last = oldUser.get(temp).indexOf(recoder[temp]);
                        if (index_now < index_last) {
                            ans[recoder[temp]] = 0;
                            recoder[temp] = i;
                            ans[i] = temp;
                        }
                    }
                    flag = true;
                }
            }
            if (flag==false) break;
            else flag=false;
        }
        for (int i = 1; i <= NUM; i++) {
            System.out.println(i + " " + ans[i]);
        }
    }
}
