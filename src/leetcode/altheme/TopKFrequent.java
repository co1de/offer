package leetcode.altheme;

import java.util.*;

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 0);
            } else {
                int tempVal = map.get(nums[i]);
                map.put(nums[i], ++tempVal);
            }
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> (map.get(n1) - map.get(n2)));
        for (Integer key : map.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> ret = new ArrayList<>();
        while (!heap.isEmpty()) {
            ret.add(heap.poll());
        }
        Collections.reverse(ret);
        return ret;
    }
}
