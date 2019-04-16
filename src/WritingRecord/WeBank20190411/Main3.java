package WritingRecord.WeBank20190411;

import java.util.Scanner;

/**
 * @program: offer
 * @description: 奇数偶数跳格子，奇数3n+1,偶数n/2,判断多少次
 * @author: co1de
 * @create: 2019-04-11 19:44
 **/

public class Main3 {
    public static int judge(int n){
        int ret = 0;
        while (n > 1) {
            //奇数跳两次
            if (n % 2 != 0) {
                n = (3*n+1)/2;
                ret+=2;
            }else {
                //偶数跳一次
                n = n/2;
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        String[] s = sc.nextLine().split(" ");
        int[] all= new int[t];
        int k=0;
        for (String ss:s){
            all[k++] = Integer.valueOf(ss);
        }

        for (int i=0;i<t;i++) {
            System.out.println(judge(all[i]));
        }
    }
}
