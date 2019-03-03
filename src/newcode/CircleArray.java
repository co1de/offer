package newcode;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
public class CircleArray {
    public static void main(String[] args) {
        int[] array = {1,0,1,1,1};
        System.out.println(minNumberInRotateArray(array));
    }
    public static int minNumberInRotateArray(int [] array) {
        int low = 0;
        int high = array.length-1;
        int mid = (low+high)/2;
        int mark = 0;
        while (low<=high){
            if (array[mid]>array[mid+1]){
                mark = mid +1;
                break;
            }else if (array[mid] <= array[mid+1]){
                low = mid;
                mid = low+(high-low)/2;
            }
        }
        return array[0] > array[mark] ? array[mark] : array[0];
//        int result = 0;
//        if (array.length == 0) return result;
//        int min=array[0];
//        for (int i=1;i<array.length;i++){
//            if (array[i]<min){
//                min = array[i];
//            }
//        }
//        return min;
    }
}
