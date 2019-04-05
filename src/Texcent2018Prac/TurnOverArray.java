package Texcent2018Prac;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: offer
 * @description: 小Q定义了一种数列称为翻转数列: 给定整数n和m, 满足n能被2m整除。对于一串连续递增整数数列1, 2, 3, 4..., 每隔m个符号翻转一次, 最初符号为'-';。 例如n = 8, m = 2, 数列就是: -1, -2, +3, +4, -5, -6, +7, +8. 而n = 4, m = 1, 数列就是: -1, +2, -3, + 4. 小Q现在希望你能帮他算算前n项和为多少。
 * @author: co1de
 * @create: 2019-04-04 17:03
 **/

public class TurnOverArray {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int n = scanner.nextInt();
        long m = scanner.nextLong();
        if (n%(2*m)!=0) return;
        long[] arr = new long[n];
//        ArrayList<Long> arr = new ArrayList<>();
        int p = -1;
        long k = m ;
        for (int i=0;i<n;i++){
            if (k==0){
                p=-p;
                k = m;
            }
            arr[i]= p*i;
//            arr.add(p*i);
            k--;
        }
        long sum = 0;
        for (int i=0;i<n;i++) {
            sum+=arr[i];
//            sum += arr.get(i);
        }
//        for (Long v:arr){
//            sum+=v;
//        }
        System.out.println(sum);
    }
}
