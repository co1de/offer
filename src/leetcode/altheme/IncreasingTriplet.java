package leetcode.altheme;

import java.util.Arrays;

public class IncreasingTriplet {
    public boolean increasingTriplet2(int[] nums) {
        if (nums==null || nums.length==0) return false;
        int[] slot = new int[3];
        Arrays.fill(slot,Integer.MIN_VALUE);
        slot[0] = nums[0];
        int slotPointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > slot[slotPointer]) {
                slotPointer++;
                if (slotPointer == 2) {
                    return true;
                }
                slot[slotPointer] = nums[i];
            } else if (nums[i] < slot[slotPointer]){
                int old = slotPointer;
                //找到更新位置
                for (int j = 0; j < slot.length; j++) {
                    if (nums[i] <= slot[j]) {
                        slotPointer=j;
                        break;
                    }
                }
                slot[slotPointer] = nums[i];
                //恢复原位置
                slotPointer = old;
            }
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        int beforeMin = Integer.MIN_VALUE;
        int ctn = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > beforeMin) {
                beforeMin = nums[i];
                ctn++;
            }else{
                beforeMin = nums[i];
                ctn=1;
            }

            if (ctn >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,0,4,6};
        int[] arr1 = {2,4,-2,-3};
        int[] arr2 = {2,1,5,0,3};
        int[] arr3 = {5,1,5,5,2,5,4};
        int[] arr4 = {1,2,1,2,1,2,1,2,1,2};
        int[] arr5 = {1,0,0,0,10,0,0,0,0,0,1000000};
        System.out.println(new IncreasingTriplet().increasingTriplet2(arr5));
    }
}
