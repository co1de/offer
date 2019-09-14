package leetcode.altheme;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

interface NestedInteger {
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
      // @return the single integer that this NestedInteger holds, if it holds a single integer*
      // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
}
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> queue = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.queue = new LinkedList<Integer>();
        dfs(nestedList);
    }

    private void dfs(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        for (NestedInteger each : nestedList) {
            if (each.isInteger()) {
                queue.add(each.getInteger());
            } else {
                dfs(each.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return queue.size()>0;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */