package WritingRecord.WeBank20190411;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-11 20:34
 **/

public class Solution {
    private static void jsoephus_func(int totalNum, int cycleNum) {
        //定义链表
        List<Integer> list = new ArrayList<Integer>();//初始的人数
        List<Integer>  resultlist = new ArrayList<Integer>();//点到人
        for(int i=1;i<=totalNum;i++){//把所有的猴子的编号都保存到链表中去
            list.add(i);
        }
        int count = 0;
        for(int j =0;j<totalNum;j++){
            count = (--count+cycleNum)%list.size();
            if (j!=totalNum-2){
                System.out.print(list.get(count));//将选中的每一个猴子的编号都打印出来
                System.out.print(" ");
            }else{

                System.out.println(list.get(count));
            }

            resultlist.add(list.remove(count));//将点到的每一个猴子的编号都保存到链表中，最后一个即是我们想要的答案
        }
//        System.out.println(resultlist.get(resultlist.size()-1));//打印出最后一个点到猴子的编号
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入总的数目：");
        int totalNum = sc.nextInt();
//        System.out.println("请输入报数的编号:");
        int cycleNum = sc.nextInt();
        jsoephus_func(totalNum,cycleNum);
    }


}



