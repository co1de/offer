package Texcent2018Prac;

import java.util.Scanner;

/**
 * @program: offer
 * @description: 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力
 * @author: co1de
 * @create: 2019-04-04 17:49
 **/

public class MrQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        //最后一天吃一块
        int eat = 1;
        int sum =0;
        for(int i=0;i<n;i++){
            if (i==0){
                eat = 1;
                sum+=eat;
            }else {
                eat = eat * 2;
                sum+=eat;
            }
        }
        eat = m - (sum-eat);
        System.out.println(eat);
    }
}
