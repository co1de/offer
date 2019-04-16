package WritingRecord.Qihu36020190403;

import java.util.Scanner;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-04-03 22:04
 **/

public class Temp3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        // 读数组
//        int[] arr = new int[n];
//        String[] temp = scanner.nextLine().split(" ");
//        for (int i=0;i<n;i++){
//            arr[i] = Integer.valueOf(temp[i]);
//        }
        //读m行数据
        while (T>0){
            int[] arr = new int[4];
            String[] temp = scanner.nextLine().split(" ");
            for (int i=0;i<4;i++){
                arr[i] = Integer.valueOf(temp[i]);
            }
            getGroup(arr);
            T--;
        }

    }

    private static void getGroup(int[] arr) {
        int groups = 0;
        groups += arr[3];
        while (arr[2]>0){
            if (arr[0]>=1){
                arr[2]=arr[2]-1;
                arr[0]=arr[0]-1;
                groups++;
            }else {
                //找不到1能配合了，退出
                break;
            }
        }
        while (arr[1]>0){
            //先找2配合
            if (arr[1]>=2){
                arr[1]=arr[1]-2;
                groups++;
            } //找不到2了，找两个1配合
            else if (arr[0]>=2) {
                arr[1]--;
                arr[0]=arr[0]-2;
                groups++;
            }else break;//都找不到了，直接退出
        }

        System.out.println(groups);
    }
}
