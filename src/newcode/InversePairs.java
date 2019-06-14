package newcode;

/**
 * @program: offer
 * @description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * @author: co1de
 * @create: 2019-06-13 20:35
 **/

public class InversePairs {
    private long count = 0;
    private int[] tmp;
    public int InversePairs(int [] array) {
        if (array == null) {
            return 0%1000000007;
        }
        tmp = new int[array.length];
        merageSort(array, 0, array.length - 1);
        return (int)(count%1000000007);
    }

    private void merageSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        merageSort(array, start, middle);
        merageSort(array, middle + 1, end);
        merge(array, start, middle, end);
    }

    private void merge(int[] array, int start, int middle, int end) {
        //左边开头
        int low = start;
        //右边开头
        int high = middle+1;
        for (int i = start; i <= end ; i++) {
            tmp[i] = array[i];
        }
        for (int i = start; i <= end; i++) {
            if (low > middle) {
                //左边结束，右边继续
                array[i] = tmp[high++];
            } else if (high > end) {
                //右边结束，左边继续
                array[i] = tmp[low++];
            } else if (tmp[low] > tmp[high]) {
                //出现逆序对,low自己和后面的都会大于array[high]
                count += middle-low+1;
//                count++;
                array[i] = tmp[high++];
            } else if (tmp[low] < tmp[high]) {
                array[i] = tmp[low++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(new InversePairs().InversePairs(a));
    }
}
