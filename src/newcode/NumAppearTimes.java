package newcode;

/**
 * @program: offer
 * @description: 统计一个数字在排序数组中出现的次数。
 * @author: co1de
 * @create: 2019-06-14 20:53
 **/

public class NumAppearTimes {
    public int GetNumberOfK(int [] array , int k) {
        int ret=0;
        if (array != null && array.length != 0) {
            int first = binarySearchTimesAhead(array, k);
            int last = binarySearchTimesAhead(array, k);
            if (first != -1 && last != -1) {
                 ret = last - first + 1;
            }
        }
        return ret;
    }

    public int binarySearchTimesAhead(int[] arr, int k) {
        if (arr==null || arr.length==0) return -1;
        int low = 0;
        int high = arr.length-1;
        int ret =-1;
        while (low <= high) {
            int middle = low+(high-low)/2;
            if (arr[middle] < k) {
                low=middle+1;
            } else if (arr[middle] > k) {
                high=middle-1;
            }else {
                //如果直接相等了,看一下前面是不是还有k
//                if (arr[middle-1] == k) {
//                    high = middle-1;
//                }else ret = middle;
                if ((middle > 0 && arr[middle - 1] != k) || middle == 0) {
                    ret = middle;
                }else high=middle-1;
            }
        }
        return ret;
    }
    public int binarySearchTimesTail(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int low = 0, high = arr.length - 1, ret = -1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < k) {
                low=middle+1;
            } else if (arr[middle] > k) {
                high = middle - 1;
            } else {
//                if (arr[middle + 1] == k) {
//                    low = middle + 1;
//                }else ret = middle;
                if ((middle < arr.length-1 && arr[middle + 1] != k) || middle == arr.length-1) {
                    ret = middle;
                }else low=middle+1;
            }
        }
        return ret;
    }

    public int GetNumberOfK2(int [] array , int k) {
        int ret=0;
        if (array != null && array.length != 0) {
            int first = binarySearchTimes(array, k-0.5);
            int last = binarySearchTimes(array, k+0.5);
            if (first != -1 && last != -1) {
                //注意这里，不用+1了，因为k-0.5搜到的是起始值，k+0.5搜到的比k+0.5大的（比目标值大的下一个）
                //二者差即为目标值个数，比如1，2，2，2，前者搜到1，后者搜到4
                ret = last - first ;
            }
        }
        return ret;
    }

    public int binarySearchTimes(int[] arr, double k) {
        int low =0,high = arr.length-1,ret=-1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] <= k) {
                low = middle+1;
            } else if (arr[middle] > k) {
                high = middle-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2};

         System.out.println(new NumAppearTimes().binarySearchTimes(a,2-0.5));
        System.out.println(new NumAppearTimes().binarySearchTimes(a,2+0.5));

    }
}
