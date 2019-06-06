package base;

/**
 * @program: offer
 * @description:
 * @author: co1de
 * @create: 2019-05-29 21:19
 **/

public class MaxHeap {
        private int[] temp;
        private int size = 0;

        public void setTemp(int[] temp) {
            this.temp = temp;
        }
    /**
     * @Description: 为可能出现的交换操作提供公共方法
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/5/24
     */
    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

        //对于较大的元素，上浮上去,树结构中父节点坐标是k/2
        private void swim(int k) {
            while (k > 1 && temp[k / 2] < temp[k]) {
                exchange(temp, k / 2, k);
                //追踪到新位置，继续判断
                k = k / 2;
            }
        }
        //对于较小的元素，下沉到合适的位置,树结构中子节点为2*k和2*k+1
        private void sink(int k) {
            while (2 * k < size) {
                int l = 2*k;
                //在左右孩子中找最大的
                if (temp[l] < temp[l + 1]) {
                    l = l+1;
                }
                if (temp[k] < temp[l]) {
                    exchange(temp, k, l);
                    //追到新位置继续
                    k = l;
                }else break;
            }
        }

        private void insert(int key) {
            temp[++size] = key;
            swim(size);
        }

        private int getMax() {
            int max = temp[1];
            exchange(temp, 1, size--);
//            temp[size+1] = -1; 防止游离
            sink(1);
            return max;
        }


}
