package newcode;

import java.util.ArrayList;

/**
 * @program: offer
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @author: co1de
 * @create: 2019-03-21 20:22
 **/

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int circle = matrix[0].length>matrix.length? (int) (Math.ceil(matrix[0].length) / 2.0) : (int) Math.ceil(matrix.length / 2.0);
        ArrayList<Integer> res = new ArrayList<>();
        //长度为1,或是横竖单行
        if (circle==0 || matrix.length==1 || matrix[0].length==1){
            for (int i = 0; i <matrix.length ; i++) {
                for (int j = 0; j <matrix[0].length ; j++) {
                    res.add(matrix[i][j]);
                }
            }
            return res;
        }
        //当前圈数
        int curCir = 0;
        int curX=0,curY=0;
        while (curCir<circle){
            //->
            int tempxlen = curY+matrix[0].length-2*curCir-1;
//            if (tempxlen<=0) res.add(matrix[curX][curY]);
            //5*5时中间那个位置
            if (curY==tempxlen) res.add(matrix[curX][curY]);
            while (curY<tempxlen){
                res.add(matrix[curX][curY++]);
            }
            //down
            int tempylen = curX+matrix.length-2*curCir-1;
            while (curX<tempylen){
                res.add(matrix[curX++][curY]);
            }
            //<-
            while (curY>curCir){
                res.add(matrix[curX][curY--]);
            }
            //up
            while (curX>curCir){
                res.add(matrix[curX--][curY]);
            }
            //回到对角线起始点
            curX++;
            curY++;
            curCir++;
        }

        return res;
    }


    /** 
    * @Description: 这段代码的思路也挺清晰，比较容易理解 
    * @Param:  
    * @return:  
    * @Author: co1de
    * @Date: 2019/3/22 
    */ 
    public ArrayList<Integer> printMatrix2(int[][] matrix) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (matrix==null || matrix.length==0) return ret;
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++)
                ret.add(matrix[r1][i]);
            for (int i = r1 + 1; i <= r2; i++)
                ret.add(matrix[i][c2]);
            if (r1 != r2)
                for (int i = c2 - 1; i >= c1; i--)
                    ret.add(matrix[r2][i]);
            if (c1 != c2)
                for (int i = r2 - 1; i > r1; i--)
                    ret.add(matrix[i][c1]);
            r1++; r2--; c1++; c2--;
        }
        return ret;
    }
    
    public static void main(String[] args) {
        PrintMatrix pm = new PrintMatrix();
//        int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        int[][] a = {{1},{2},{3},{4},{5}};
        System.out.println(Math.ceil(5/2.0));
        pm.printMatrix(a).forEach(t-> System.out.print(t+" "));
    }
}
