package WritingRecord.Qihu36020190403;

import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-03 20:48
 **/

public class Temp2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        // 读数组
        int[] arr = new int[n];
        String[] temp = scanner.nextLine().split(" ");
        for (int i=0;i<n;i++){
            arr[i] = Integer.valueOf(temp[i]);
        }
        //读m行数据
        while (m>0){
            int t = scanner.nextInt();
            int x = scanner.nextInt();
            getArr(arr,t,x);
            scanner.nextLine();
            m--;
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void getArr(int[] arr,int t,int x) {
        //升序
        if (t==0){
            //开始调整顺序
            for (int i =0;i<x;i++) {
                for (int j=i+1;j<x;j++){
                    if (arr[i]>arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        //降序
        if(t==1){
            //开始调整顺序
            for (int i =0;i<x;i++) {
                for (int j=i+1;j<x;j++){
                    if (arr[i]<arr[j]){
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

}
