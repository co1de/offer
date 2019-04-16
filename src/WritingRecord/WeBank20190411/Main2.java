package WritingRecord.WeBank20190411;

import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-11 19:55
 **/

public class Main2 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int k = sc.nextInt();
            int m = sc.nextInt();
            if (n>=m) {
                if (n*k % m ==0){
                        //能整除
                        System.out.println(n*k/m);
                }else {
                    //总共需要教n*k个技能
                        System.out.println((n*k/m)+1);
                }
            }
            else {
                System.out.println(k);
            }
    }
}



