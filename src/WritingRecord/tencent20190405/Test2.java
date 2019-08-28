package WritingRecord.tencent20190405;

import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-05 20:37
 **/

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //最大面值
        int m = sc.nextInt();
        //不同面值数。
        int n = sc.nextInt();
        int ans = 0, x;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                x = sc.nextInt();
                ans += x;
            }
        }
        System.out.println(ans);
    }
}
