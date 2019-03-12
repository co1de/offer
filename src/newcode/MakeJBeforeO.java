package newcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: offer
 * @description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: co1de
 * @create: 2019-03-12 19:36
 **/

public class MakeJBeforeO {

    public void reOrder(int[]a){

    }


    public void reorder(int[] a){
        if (a!=null){
            int front = 0;
            int end = a.length-1;
            int temp=0;
            while (front<=end){
                while (a[front]%2==1){
                    front++;
                }
                while (a[end]%2==0){
                    end--;
                }
                if (front<=end){
                    temp = a[front];
                    a[front] = a[end];
                    a[end] = temp;
                }

            }
        }
    }


    public void reOrderArray(int [] array) {
        ArrayList<Integer> ji = new ArrayList<>();
        ArrayList<Integer> ou = new ArrayList<>();
        for (int i=0;i<array.length;i++){
            if (array[i]%2==0){
                ou.add(array[i]);
            } else ji.add(array[i]);
        }
        int k=0;
        for (int i=0;i<ji.size();i++){
            array[k++]=ji.get(i);
        }

        for (int i=0;i<ou.size();i++){
            array[k++]=ou.get(i);
        }
    }

    public static void main(String[] args) {
        MakeJBeforeO mjbo = new MakeJBeforeO();
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        mjbo.reorder(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.print(' ');
            System.out.print(a[i]);
        }
    }
}
