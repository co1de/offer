package tencent20190405;

import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-05 20:44
 **/

public class Test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        long[] power = new long[N];
        int[] money = new int[N];
        String[] temp = scanner.nextLine().split(" ");
        for (int i=0;i<power.length;i++){
            power[i] = Integer.valueOf(temp[i]);
        }
        temp = scanner.nextLine().split(" ");
        for (int i=0;i<power.length;i++){
            money[i] = Integer.valueOf(temp[i]);
        }

        long myPower = 0;
        int myMoney = 0;
        for (int i=0;i<N-1;i++){
            //打不过就买
            if (myPower<power[i]){
                //买下来
                myMoney+=money[i];
                //增加武力值
                myPower+=power[i];
            }else if (myMoney+power[i]<=power[i+1]){
                //看看能否打过下一个，打不过就把当前的也买上
                //买下来
                myMoney+=money[i];
                //增加武力值
                myPower+=power[i];
            }
        }
        //看最后一只能不能打过
        if (myPower<power[N-1]){
            myMoney+=money[N-1];
            //增加武力值
            myPower+=power[N-1];
        }
        System.out.println(myMoney);

    }
}
