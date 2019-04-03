package Qihu36020190403;

import java.io.InputStream;
import java.util.Collections;
import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-03 20:09
 **/

public class Temp {
    public static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        int moveCount = arr.length;
        int tempSum = 0;
        while (moveCount>0) {
            //进行一次计算
            int k =1;
            for (int i=0;i<arr.length;i++) {
                tempSum=tempSum+Math.abs(arr[i]-(k++));
                if (tempSum>min) break;
            }
            //更新最小值
            if (tempSum<min) {
                min = tempSum;
            }
            //最小值清0;
            tempSum=0;
            //调整一次数组；
            int temp = arr[0];
            for (int i=0;i<arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=temp;
            //更新移动次数
            moveCount--;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        scanner.nextLine();
        int[] arr = new int[length];
        String[] temp = scanner.nextLine().split(" ");
        for (int i=0;i<length;i++){
            arr[i] = Integer.valueOf(temp[i]);
        }
        System.out.println(getMin(arr));
    }
}
