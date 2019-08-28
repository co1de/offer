package WritingRecord.Texcent2018Prac;

import java.util.Scanner;

/**
 * @program: offer
 * @description: 牛牛和羊羊正在玩一个纸牌游戏。这个游戏一共有n张纸牌, 第i张纸牌上写着数字ai。 牛牛和羊羊轮流抽牌, 牛牛先抽, 每次抽牌他们可以从纸牌堆中任意选择一张抽出, 直到纸牌被抽完。 他们的得分等于他们抽到的纸牌数字总和。 现在假设牛牛和羊羊都采用最优策略, 请你计算出游戏结束后牛牛得分减去羊羊得分等于多少。
 * @author: co1de
 * @create: 2019-04-04 17:32
 **/

public class CardGame {

        public static void main(String[] args) {
            Scanner scanner =new Scanner(System.in);
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] s = scanner.nextLine().split(" ");
            long[] all= new long[n];
            int k=0;
            for (String ss:s){
                all[k++] = Long.valueOf(ss);
            }
            long[] niu= new long[n/2+1];
            long[] yang= new long[n/2+1];

            for (int i=0;i<n/2+1;i++){
                //牛牛先
                niu[i]=findMax(all);
                //羊羊后
                yang[i] = findMax(all);
            }
            long sumNiu = 0;
            for (int i=0;i<niu.length;i++) {
                sumNiu+=niu[i];
            }

            long sumYang = 0;
            for (int i=0;i<yang.length;i++) {
                sumYang+=yang[i];
            }
            System.out.println(sumNiu-sumYang);

        }

    private static long findMax(long[] all) {
            long max = 0;
            int pos=0;
            for (int i=0;i<all.length;i++) {
                if (all[i]>max){
                    max = all[i];
                    pos=i;
                }
            }
            all[pos]=0;
            return max;
    }


}
