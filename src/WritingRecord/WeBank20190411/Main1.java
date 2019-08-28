package WritingRecord.WeBank20190411;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: offer
 * @description: 约瑟夫环
 * @author: co1de
 * @create: 2019-04-11 20:31
 **/

public class Main1 {
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m < 1)
            return -1;
        int[] childs = new int[n];
        Arrays.fill(childs, 0);
        int rounds = n;
        int startChild = 0, shift, voiceNum, i, j;
        while (rounds > 1) {
            if (m > rounds)
                shift = m % rounds;
            else
                shift = m;
            voiceNum = 0;
            if (shift == 0)
                shift = rounds;
//            System.out.println(rounds);
            for (i = startChild; ; i++) {
                if (i == n)
                    i = 0;
                if (childs[i] == 0) {
                    voiceNum++;
                    if (voiceNum == shift) {
                        childs[i] = 1;
                        if (rounds > 2) {
                            System.out.print(i + 1 + " ");
                        } else {
                            System.out.println(i + 1);
                        }
                        for (j = i + 1; ;j++) {
                            if (j == n)
                                j = 0;
                            if (childs[j] == 0) {
                                startChild = j;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            rounds--;
        }
        for (i = 0; i < childs.length; i++) {
            if (childs[i] == 0)
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        System.out.println(new Main1().LastRemaining_Solution(n, m) + 1);
    }
}
