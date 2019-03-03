package newcode;

public class FindNumber {

    public static void main(String[] args) {
        int[][] test = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int[][] tets = {{}};
        System.out.println(Find(5,test));
    }
//
//   题目描述
// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//
// 思路：先从第一行找到该数在哪两个数之间，记录起始位置，然后从起的位置按列比较
//
    public static boolean  Find(int target, int [][] array) {
        boolean result = false;
        int start = 0;

        if (array[0].length==0) return result;
        for (int i=0;i<array.length;i++){
            if (array[0][i]<=target){
                start = i;
            }
        }
        //外层循环是保证所有数都比目标小，反向查询
        for (int j = start;j>=0;j--){
            for (int i=0;i<array[j].length;i++){
                if (target == array[i][j]){
                    return true;
                }
            }
        }

        return result;
    }
}
