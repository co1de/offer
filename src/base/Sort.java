package base;

/**
 * @program: offer
 * @description: 排序算法合集
 * @author: co1de
 * @create: 2019-05-24 20:01
 **/

public class Sort {

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


    public static void bubbleSort(int[] arr) {
//        //需要n次排序
//        for (int i = 0; i < arr.length; i++) {
//            //相邻位置开始交换
//            for (int j = 0; j < arr.length-1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    exchange(arr,j,j+1);
//                }
//            }
//        }
        //若部分有序，可用标志位来进行优化
        boolean isSorted = false;
        for (int i = 0; i < arr.length && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j]>arr[j+1]){
                    isSorted=false;
                    exchange(arr,j,j+1);
                }
            }
        }
    }
    /**
     * @Description: 选择排序，找到最小的放到位置，再找到第二小的继续；
     * @Param:
     * @return:
     * @Author: co1de
     * @Date: 2019/5/24
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                //第i个位置放第i小的，这种写法会增加交换次数
//                if (arr[j]<arr[i]){
//                    int temp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = temp;
//                }
//            }
            //这种方式避免了额外的交换，每次只进行一次交换
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                //这里决定了升降序
                if (arr[j] < arr[min]) {
                    min=j;
                }
            }
            //将第i个与其对应的min交换
            exchange(arr,i,min);
        }
    }

    /**
    * @Description: 插入排序，插入后左边始终有序，但左边为了腾位置可能需要移动
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/5/24
    */
   public static void insertSort(int[] arr) {
       for (int i = 1; i < arr.length; i++) {
           for (int j = i; j > 0; j--) {
               //这里其实是左边挨个比较，n个数的话最多需要n-1次交换，希尔排序正是基于此优化的
                if (arr[j]<arr[j-1]){
                    exchange(arr,j,j-1);
                }
           }
       }
   }

   /**
   * @Description: 希尔排序 ，为了避免挨个比较，希尔排序认为左边可能是部分有序的，数字与一个有序块进行交换移动。
    * 更直观的理解是将其转为表，每次对列排序，再缩小列规模，直至1
    * 在大型数组中希尔排序可能快得多。
   * @Param:
   * @return:
   * @Author: co1de
   * @Date: 2019/5/24
   */
    public static void shellSort(int[] arr) {
       //希尔排序思想的核心，是数组中间隔h的元素都是有序的
        int h = 1;
        //一种h的选取
        while(h<arr.length/3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {
                //注意这里的条件
                for (int j = i; j >= h; j -= h) {
                    if (arr[j]<arr[j-h]){
                        exchange(arr,j,j-h);
                    }
                }
            }
            h=h/3;
        }
    }

    /**
    * @Description: 归并排序，自顶向下进行
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/5/28
    */

    public static void mergeSortUp2Bottom(int[] arr, int low, int high) {
        if (low >= high) {
            return ;
        }

        int middle = low + (high - low) / 2;
        mergeSortUp2Bottom(arr, low, middle);
        mergeSortUp2Bottom(arr, middle + 1, high);
        merge(arr, low, middle, high);
//        return arr;
    }

    public static void mergeSortBottom2Up(int[] arr) {
        //子数组规模
        for (int i = 1; i < arr.length; i+=i) {
            //子数组下标
            int times= 0;
            //截止条件长度减去规模，就是最后一组要归并的开始坐标
            //j每次移动两个i，因为两个i都已经归并了，需要移动两个i。
            for (int j = 0; j < arr.length-i; j += i+i) {
                merge(arr,j,j+i-1,Math.min(j+i+i-1,arr.length-1));
            }
        }
    }

    /**
    * @Description: 归并排序的合并过程,原地归并,需要辅助空间
    * @Param:
    * @return:
    * @Author: co1de
    * @Date: 2019/5/28
    */
    private static int[] temp ;
    private static void merge(int[] arr, int low, int middle, int high) {
        int aheard = low;
        int last = middle+1;
        //填入temp数组，准备开始从temp中取出数字进行归并
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        //开始合并两段数组
        for (int i = low; i <= high; i++) {
             if (aheard > middle) {
                // 前半部分取完，直接复制后半部分剩余的内容
                arr[i] = temp[last++];
            } else if (last > high) {
                // 后半部分取完，直接复制前半部分剩余的内容
                arr[i] = temp[aheard++];
            } else if (temp[aheard]>temp[last]){
                //大于则取后面的，并移动指针
                arr[i] = temp[last++];
            } else if (temp[aheard] < temp[last]) {
                arr[i] = temp[aheard++];
            }
        }
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int k = partation(arr, low, arr.length - 1);
        quickSort(arr, low, k-1);
        quickSort(arr,k+1,high);
    }

    public static int partation(int[] arr, int low, int high) {
        //选择切分元素,一般选第一个，随意的
        int pos = arr[low];
        int i = low;
        int j = high+1;
        while (true) {
            //找到左边第一个大于标记的数字
            while (i<high && arr[++i]<pos);
            //找到右边第一个小于标记的数字
            while (j > low && arr[--j] > pos);
            if (i >= j) {
                break;
            }
            exchange(arr,i,j);
        }
        exchange(arr,low,j);
        return j;
    }

    public static void quickSortBy3Way(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        int lt=low;
        int i = low+1;
        int gt = high;
        int pos = arr[low];
        //未确定部分还没扫描完，就继续扫描
        while (i <= gt) {
            if (arr[i] < pos) {
                //小于时，交换位置，并移动指针
                exchange(arr,lt++,i++);
            } else if (arr[i] > pos) {
                //大于时，将其放到最后，并缩小范围
                exchange(arr, i, gt--);
            } else {
//                说明i位置和pos相等，移动i，此时lt与i之间的值都与pos相等
                i++;
            }
        }
        //扫描完后，数组被切分为三部分，low-lt部分小于pos，lt-gt部分等于pos，gt以上部分大于pos，
        //只需对两边继续进行排序即可。
        quickSortBy3Way(arr, low, lt - 1);
        quickSortBy3Way(arr, gt + 1, high);
    }

    public static int binarySearch(int[] arr, int goal,int start,int end) {
        int result = -1;
        if (start>end) return result;
//        int middle = arr.length/2;
        int middle = (start+end)/2;
        if (arr[middle]>goal){
            result = binarySearch(arr, goal,start,middle-1);
        } else if (arr[middle] < goal) {
            result = binarySearch(arr, goal, middle + 1, end);
        }else result = middle;
        return result;
    }

    public static int binarySerach(int[] arr,int goal) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] < goal) {
                low = middle+1;
            } else if (arr[middle] > goal) {
                high = middle-1;
            }else return middle;
        }
        return low;
    }

//    static class MaxHeap{
//        private int[] temp;
//        private int size = 0;
//
//        public void setTemp(int[] temp) {
//            this.temp = temp;
//        }
//
//        //对于较大的元素，上浮上去,树结构中父节点坐标是k/2
//        private void swim(int k) {
//            while (k > 1 && temp[k / 2] < temp[k]) {
//                exchange(temp, k / 2, k);
//                //追踪到新位置，继续判断
//                k = k / 2;
//            }
//        }
//        //对于较小的元素，下沉到合适的位置,树结构中子节点为2*k和2*k+1
//        private void sink(int k) {
//            while (2 * k < size) {
//                int l = 2*k;
//                //在左右孩子中找最大的
//                if (temp[l] < temp[l + 1]) {
//                    l = l+1;
//                }
//                if (temp[k] < temp[l]) {
//                    exchange(temp, k, l);
//                    //追到新位置继续
//                    k = l;
//                }else break;
//            }
//        }
//
//        private void insert(int key) {
//            temp[++size] = key;
//            swim(size);
//        }
//
//        private int getMax() {
//            int max = temp[1];
//            exchange(temp, 1, size--);
////            temp[size+1] = -1; 防止游离
//            sink(1);
//            return max;
//        }
//    }

    public static void heapSort(int[] arr) {
        //先建堆,从length/2即第一个非页节点开始
        for (int i = arr.length / 2; i >= 1; i--) {
            sink(arr, i, arr.length - 1);
        }
        //每次将最大数放入最后但不删除，直至第一个数，即完成了堆排序
        int pos = arr.length-1;
        while (pos > 1) {
            exchange(arr, 1, pos--);
            sink(arr,1,pos);
        }
    }

    public static void sink(int[] arr, int i, int N) {
        //可以取等是因为传进来的不是长度而是位置。
        while (i * 2 <= N) {
            int j = i*2;
            //注意要j<n
            if (j<N && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[i] < arr[j]) {
                exchange(arr,i,j);
                i = j;
            }else break;
        }
    }

    // TODO: 2019/6/18 待完成计数排序 
    public static void countingSort() {
        
    }
    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        Sort.bubbleSort(a);
//        Sort.selectSort(a);
//        Sort.insertSort(a);
//        Sort.shellSort(a);
        temp = new int[a.length];
//        Sort.mergeSortUp2Bottom(a,0,a.length-1);
//        Sort.mergeSortBottom2Up(a);
//        Sort.quickSort(a,0,a.length-1);
//        Sort.quickSortBy3Way(a, 0, a.length - 1);
//        System.out.println(Sort.binarySearch(a,3,0,a.length-1));
        Sort.heapSort(a);
        System.out.println(Sort.binarySerach(a, 4));
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
