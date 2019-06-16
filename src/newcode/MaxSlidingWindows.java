package newcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: offer
 * @description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * @author: co1de
 * @create: 2019-06-16 21:02
 **/

public class MaxSlidingWindows {
    /** 
    * @Description: 用一个大顶堆来维护队列即可。
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/16 
    */ 
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        if (size<=num.length){
            for (int i = 0; i+size < num.length; i++) {
                for (int j = i; j-i+1<= size; j++) {
                    queue.add(num[j]);
                }
                if (queue.peek()!=null){
                    ret.add(queue.poll());
                }
                queue.clear();
            }
            for (int i = num.length - 1 - size + 1; i < num.length; i++) {
                queue.add(num[i]);
            }
            if (queue.peek()!=null){
                ret.add(queue.poll());
            }
        }
        return ret;
    }

    //尝试使用一个大小为3的大顶堆。
    public ArrayList<Integer> maxInWindows2(int [] num, int size)
    {
        ArrayList<Integer> ret = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2-o1));

        if (size<=num.length && size>0){
            //初始化
            for (int i = 0; i < size; i++) {
                queue.add(num[i]);
            }
            ret.add(queue.peek());
            for (int i = 0, j = i + size; j < num.length; i++, j++) {
                queue.remove(num[i]);
                queue.add(num[j]);
                ret.add(queue.peek());
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> ret = new MaxSlidingWindows().maxInWindows(a, 3);
        for (Integer i : ret) {
            System.out.print(i+" ");
        }
    }
}
