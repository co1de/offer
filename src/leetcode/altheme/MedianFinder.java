package leetcode.altheme;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    PriorityQueue<Integer> maxQueue = new PriorityQueue<>((s1,s2)->(s2-s1));
    int N = 0;
    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (N % 2 == 1) {
            minQueue.add(num);
            maxQueue.add(minQueue.poll());
        } else {
            maxQueue.add(num);
            minQueue.add(maxQueue.poll());
        }
        N++;
    }

    public double findMedian() {
        int total = maxQueue.size() + minQueue.size();
        if ((total & 1) == 0) {
            //odd
            return (minQueue.peek() + maxQueue.peek()) / 2.0;
        } else {
            //even
            return minQueue.peek();
        }
    }
}
