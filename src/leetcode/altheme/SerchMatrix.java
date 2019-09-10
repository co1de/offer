package leetcode.altheme;


public class SerchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0) return false;
        int row = matrix.length-1;
        int col = 0;
        while (row>=0 && col<matrix[0].length) {
            if (target > matrix[row][col]) {
                col++;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length==0 || matrix[0].length==0) return false;
//        int[] rowtemp = new int[matrix[0].length];
//        for (int i = 0; i < matrix[0].length; i++) {
//            rowtemp[i] = matrix[0][i];
//        }
////        int col = binarySearchUp(rowtemp, target);
//        int col = binarySearchUp(rowtemp, target);
//        int[] coltemp = new int[matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            coltemp[i] = matrix[i][col];
//        }
//        int row = binarySearchUp(coltemp, target);
//        return matrix[row][col]==target;
//    }

//    public int binarySearch(int[] arr, int target,int start,int end) {
//        int result = -1;
//        if (start > end) {
//            return result;
//        }
//        int middle = (end+start)/2;
//        if (arr[middle] > target) {
//            result = binarySearch(arr, target, start, middle - 1);
//        } else if (arr[middle] < target) {
//            result = binarySearch(arr, target, middle + 1, end);
//        } else {
//            result = middle;
//        }
//        return result;
//    }

    public int binarySearchUp(int[] arr, int target) {
        int ret =-1;
        int low=0;
        int high=arr.length-1;
        while (low < high) {
            int mid = low+(high-low)/2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low=mid;
                return mid;
            }
        }
        return low;

    }

    public static void main(String[] args) {
        int[][] tmp = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int[][] tmp2 = {
                {1,1}
        };
        int[][] tmp3 = {
                {-1},
                {-1}
        };
        int[][] tmp4 = {
                {1},
                {3},
                {5}
        };
        int[][] tmp5 = {
                {-1,-3}
        };
        int[][] tmp6 = {
                {1,4},
                {2,5}
        };
        System.out.println(new SerchMatrix().searchMatrix(tmp,20));
    }
}
