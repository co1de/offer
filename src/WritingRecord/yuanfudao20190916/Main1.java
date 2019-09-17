package WritingRecord.yuanfudao20190916;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n==0 || m==0) return;
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][i] = sc.nextInt();
            }
        }
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix.length==1){
            for (int i = 0; i <matrix.length ; i++) {
                for (int j = matrix[0].length-1; j >=0 ; j--) {
                    ret.add(matrix[i][j]);
                }
            }
            for (int i = 0; i < ret.size(); i++) {
                if (i == ret.size() - 1) {
                    System.out.print(ret.get(i));
                } else {
                    System.out.print(ret.get(i)+" ");
                }
            }
            return;
        }
        if (matrix[0].length==1){
            for (int i = 0; i <matrix.length ; i++) {
                for (int j = 0; j <matrix[0].length ; j++) {
                    ret.add(matrix[i][j]);
                }
            }
            for (int i = 0; i < ret.size(); i++) {
                if (i == ret.size() - 1) {
                    System.out.print(ret.get(i));
                } else {
                    System.out.print(ret.get(i)+" ");
                }
            }
            return;
        }

        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[i][r1]);
            for (int i = r1 + 1; i <= r2; i++)
                ret.add(matrix[c2][i]);
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    ret.add(matrix[i][r2]);
            if (c1 != c2)
                for (int i = r2 - 1; i > r1; i--)
                    ret.add(matrix[c1][i]);
            r1++; r2--; c1++; c2--;
        }

        for (int i = 0; i < ret.size(); i++) {
            if (i == ret.size() - 1) {
                System.out.print(ret.get(i));
            } else {
                System.out.print(ret.get(i)+" ");
            }
        }
    }
//    public static ArrayList<Integer> printMatrix(int [][] matrix) {
//        int circle = matrix[0].length>matrix.length? (int) (Math.ceil(matrix[0].length) / 2.0) : (int) Math.ceil(matrix.length / 2.0);
//        ArrayList<Integer> res = new ArrayList<>();
//        //长度为1,或是横竖单行
//        if (circle==0 || matrix.length==1 || matrix[0].length==1){
//            for (int i = 0; i <matrix.length ; i++) {
//                for (int j = 0; j <matrix[0].length ; j++) {
//                    res.add(matrix[i][j]);
//                }
//            }
//            return res;
//        }
//        //当前圈数
//        int curCir = 0;
//        int curX=0,curY=0;
//        while (curCir<circle){
//            //->
//            int tempxlen = curY+matrix[0].length-2*curCir-1;
////            if (tempxlen<=0) res.add(matrix[curX][curY]);
//            //5*5时中间那个位置
//            if (curY==tempxlen) res.add(matrix[curX][curY]);
//            while (curY<tempxlen){
//                res.add(matrix[curX][curY++]);
//            }
//            //down
//            int tempylen = curX+matrix.length-2*curCir-1;
//            while (curX<tempylen){
//                res.add(matrix[curX++][curY]);
//            }
//            //<-
//            while (curY>curCir){
//                res.add(matrix[curX][curY--]);
//            }
//            //up
//            while (curX>curCir){
//                res.add(matrix[curX--][curY]);
//            }
//            //回到对角线起始点
//            curX++;
//            curY++;
//            curCir++;
//        }

//        return res;
//    }

//        public static ArrayList<Integer> printMatrix(int[][] matrix) {
//        ArrayList<Integer> ret = new ArrayList<>();
//        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
//        while (r1 <= r2 && c1 <= c2) {
//            for (int i = c1; i <= c2; i++)
//                ret.add(matrix[r1][i]);
//            for (int i = r1 + 1; i <= r2; i++)
//                ret.add(matrix[i][c2]);
//            if (r1 != r2)
//                for (int i = c2 - 1; i >= c1; i--)
//                    ret.add(matrix[r2][i]);
//            if (c1 != c2)
//                for (int i = r2 - 1; i > r1; i--)
//                    ret.add(matrix[i][c1]);
//            r1++; r2--; c1++; c2--;
//        }
//        return ret;
//    }
}
