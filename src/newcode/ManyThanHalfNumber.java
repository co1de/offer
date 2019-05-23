package newcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: offer
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: co1de
 * @create: 2019-05-20 21:20
 **/

public class ManyThanHalfNumber {
    /** 
    * @Description: 朴素思路，用哈希表
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/5/20 
    */ 
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i:array) {
            if (map.containsKey(i)) {
                int temp = map.get(i);
                map.put(i,++temp);
            }else {
                map.put(i,1);
            }
        }

        int length = array.length/2;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()>length){
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
    * @Description: 快排partation思路,选中位数
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/5/20
    */
    public int MoreThanHalfNum_SolutionV2(int [] array) {
        if (array.length==1) return array[0];
        int mid = array.length/2;
        int start = 0;
        int end = array.length-1;
        int index = partation(array, start, end);
        while (index!=mid){
            //没找到中间，在偏右，说明中位数扔在左边
            if (index>mid){
                index = partation(array, start, index - 1);
            }else {
                //偏左，说明中位数在右边
                index = partation(array, index + 1, end);
            }
        }
        //判断中位数是否超过一半
        int coutn=0;
        for (int i : array) {
            if (i==array[mid]){
                coutn++;
            }
        }
        if (coutn>array.length/2){
            return array[mid];
        }else return 0;
    }

    public int partation(int[] array,int start,int end){
        int low = start;
        int high = end;
        int p = array[start];
        while (true) {
            while (array[low++]<p) if (low==end) break;
            while (array[high--]>p) if (high==low) break;
            if (low>=high) break;
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        int temp2 = array[start];
        array[start] = array[low];
        array[low] = temp2;
        return low;
    }

    /** 
    * @Description: 用连续子数组最大和相似的方式，用一个cnt记录数字出现的次数，cnt清零后则重新计数
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/5/21 
    */ 
    public int MoreThanHalfNum_SolutionV3(int [] array) {
        int cnt=1;
        int tempBefore = array[0];
        for (int i=1;i<array.length;i++){
            if (array[i]==tempBefore){
                cnt++;
            } else cnt--;
            if (cnt==0){
                tempBefore=array[i];
                cnt=1;
            }
        }
        //判断中位数是否超过一半
        int coutn=0;
        for (int i : array) {
            if (i==tempBefore){
                coutn++;
            }
        }
        if (coutn>array.length/2){
            return tempBefore;
        }else return 0;
    }

        public static void main(String[] args) {
        int[] a = {1,2,3,2,4,2,5,2,3};
        int[] a1 = {1,2,3,2,2,2,5,4,2};
        int[] a2 = {1};
        System.out.println(new ManyThanHalfNumber().MoreThanHalfNum_SolutionV3(a1));
    }
}
