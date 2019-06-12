package newcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @program: offer
 * @description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 * @author: co1de
 * @create: 2019-06-10 20:17
 **/

public class StreamMiddle {
    private PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    private PriorityQueue<Integer> rightMinHeap = new PriorityQueue<>();
    private int totalNum = 0;
    public void Insert(Integer num) {
        totalNum++;
        if ((totalNum&1)==0){
            /*
             * 要保证右边比左边大，先将数据放入左边，再从左边取最大放入右边，这样就能保证左边的数据始终比右边小。
             * */
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.poll());
        }else {
            rightMinHeap.add(num);
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public Double GetMedian() {
        //注意取数据用peek方法
        if ((totalNum&1)==0){
            //偶数
            return (leftMaxHeap.peek()+rightMinHeap.peek())/2.0;
        }else return (double)leftMaxHeap.peek();
    }

}
