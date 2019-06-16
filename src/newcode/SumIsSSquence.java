package newcode;

import java.util.ArrayList;

/**
 * @program: offer
 * @description: 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * @author: co1de
 * @create: 2019-06-16 10:44
 **/

public class SumIsSSquence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int low = 1;
        int high = 2;
        //这里不取等，不然会加入单向
        while (low < high) {
            //计算当前序列和
            int curSum = (low+high)*(high-low+1)/2;
            if (curSum < sum) {
                //扩大高位
                high++;
            } else if (curSum > sum) {
                //减小低位
                low++;
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for (int i = low; i <=high ; i++) {
                    temp.add(i);
                }
                ret.add(temp);
                //当前值里还可能有,不能直接跳过
                //low = high+1
                low++;
                //这里最好用high++，下面这样写也能通过，但可能会扫描重复数据。
                high=low+1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ret = new SumIsSSquence().FindContinuousSequence(100);
        for (ArrayList<Integer> arrayList : ret) {
            System.out.print("[");
            for (Integer i : arrayList) {
                System.out.print(i+",");
            }
            System.out.print("]");
        }
    }
}
