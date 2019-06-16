package newcode;

import java.util.ArrayList;

/**
 * @program: offer
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * @author: co1de
 * @create: 2019-06-16 10:16
 **/

public class SumIsSI {
    /** 
    * @Description: 思路：利用头尾两个指针进行判断 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/6/16 
    */ 
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> ret = new ArrayList<>();
        int low = 0;
        int high = array.length-1;
        while (low <= high) {
            int dis = sum-array[low];
            if (dis==array[high]){
                if (ret.size()==2){
                    //更新
                    if (array[low] * array[high]<ret.get(0)*ret.get(1)){
                        ret.clear();
                        ret.add(array[low]);
                        ret.add(array[high]);
                    }
                }
                else {
                    //直接添加
                    ret.add(array[low]);
                    ret.add(array[high]);
                }
                //注意，找到一组后，缩小规模继续找。重复数据问题可忽略，因为不影响结果（正确结果已添加）。
                low++;
                high--;
            }else if (array[high]<dis){
                low++;
            } else if (array[high] > dis) {
                high--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7, 11, 15};
        ArrayList<Integer> ret = new SumIsSI().FindNumbersWithSum(a,15);
        System.out.println(ret.get(0));
        System.out.println(ret.get(1));

    }
}
