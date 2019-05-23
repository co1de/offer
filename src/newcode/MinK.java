package newcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: offer
 * @description: 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * @author: co1de
 * @create: 2019-05-23 20:03
 **/

public class MinK {

    /** 
    * @Description: 利用堆来更快的完成 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/5/23 
    */ 
    public ArrayList<Integer> GetLeastNumbers_SolutionV2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //边界判断
        if (k>input.length || k <=0) return res;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i : input) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return res=new ArrayList<>(maxHeap);
    }

        /**
        * @Description: 利用快排partation，解决该问题。
        * @Param:
        * @return:
        * @Author: co1de
        * @Date: 2019/5/23
        */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        //边界判断
        if (k>input.length || k <=0) return res;
        int start = 0;
        int end = input.length-1;
        int purpose = partation(input, start, end);
        while (purpose != k - 1) {
            if (purpose > k - 1) {
                purpose = partation(input, start, purpose - 1);
            }
            else if (purpose < k - 1) {
                purpose = partation(input, purpose + 1, end);
            }
            else break;

        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public int partation(int[] array, int start, int end) {
        int low = start;
        int high = end+1;
        int pos = array[start];
        while (true) {
            while (low<end && array[++low]<pos  ){
//                if (low>=end) break;
            }
            while (high>start && array[--high] > pos) {
//                if (high<=start) break;
            }
            if (low >= high) {
                break;
            }
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        int temp = array[start];
        array[start] = array[high];
        array[high] = temp;
        return high;
    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8}; //4
        int[] a1 = {4,5,1,6,2,7,3,8};//8
        int[] a2 = {1};
        System.out.println(new MinK().GetLeastNumbers_Solution(a1,8));
    }
}
