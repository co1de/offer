package newcode;

/**
 *
 * 题目描述
 地上有一个m行和n列的方格。
 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 请问该机器人能够达到多少个格子？
 * */

public class RobotScope {
    public int movingCount(int threshold, int rows, int cols)
    {
        int tempSum = 0;
        int count =0;
        boolean[][] flag = new boolean[rows][cols];
        //阈值小于0不能通过
        if (threshold<0) return 0;
        //标记不可达的点
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                tempSum = getTempSum(i, j);
                if (threshold < tempSum){
                    flag[i][j] = true;
                }
            }
        }

        return judgePath(flag,0,0);
    }
    private int judgePath(boolean[][] mark,int i,int j) {
        //按上下左右的顺序判断
        mark[i][j]= true;
        int temp[] = new int[4];

        //其实这里可以反过来判断，即判断不能走的，其他都是能走的的，只用写一个判断
        //if (i < 0 || i >= rows || j < 0 || j >= cols || getTempSum(i,j)  > threshold || flag[i][j] == true){
        //可以向左
        if (j-1>=0 && mark[i][j-1]!=true){
            temp[0]=judgePath(mark,i,j-1);
        }
        //可以向右
        if (j+1<mark[0].length && mark[i][j+1] != true){
            temp[1]=judgePath(mark,i,j+1);
        }
        //可以向上
        if (i-1>=0 && mark[i-1][j] != true){
            temp[2]=judgePath(mark,i-1,j);
        }
        //可以向下
        if (i+1<mark.length && mark[i+1][j] != true){
            temp[3]=judgePath(mark,i+1,j);
        }
        //当前点加上可扩展的点
        return 1+temp[0]+temp[1]+temp[2]+temp[3];

    }

    /**
     * 理解有误，开始认为是找一条最长的路，其实这题是考连通性，从初始位置开始能到达的格子都算
     * */
//    public int movingCount(int threshold, int rows, int cols)
//    {
//        int tempSum = 0;
//        int count =0;
//        boolean[][] flag = new boolean[rows][cols];
//        //标记不可达的点
//        for (int i=0;i<rows;i++){
//            for (int j=0;j<cols;j++){
//                tempSum = getTempSum(i, j);
//                if (threshold < tempSum){
//                    flag[i][j] = true;
//                }
//            }
//        }
//
//        return judgePath(flag,0,0,0);
//    }
//    private int judgePath(boolean[][] mark,int i,int j,int len) {
//        //按上下左右的顺序判断
//        mark[i][j]= true;
//        len++;
//        int temp[] = new int[4];
//        boolean pass = false;
//        //可以向左
//        if (j-1>=0 && mark[i][j-1]!=true){
//            pass = true;
//            if (mark[i][j-1] == false){
//                temp[0] = judgePath(mark,i,j-1,len);
//            }
//        }
//        //可以向右
//        if (j+1<mark[0].length && mark[i][j+1] != true){
//            pass = true;
//            if (mark[i][j+1] == false){
//                temp[1] = judgePath(mark,i,j+1,len);
//            }
//        }
//        //可以向上
//        if (i-1>=0 && mark[i-1][j] != true){
//            pass = true;
//            if (mark[i-1][j] == false){
//                temp[2] = judgePath(mark,i-1,j,len);
//            }
//        }
//        //可以向下
//        if (i+1<mark.length && mark[i+1][j] != true){
//            pass = true;
//            if (mark[i+1][j] == false){
//                temp[3] = judgePath(mark,i+1,j,len);
//            }
//        }
//
//        //回退时清空标记
//        mark[i][j] = false;
//        if (pass == true){
//            //如果有走通的路线
//            int max=temp[0];
//            for (int k=1;k<temp.length;k++){
//                if (temp[k]>max) max=temp[k];
//            }
//            return max;
//        }else{
//            return len;
//        }
//
//    }

    private int getTempSum(int i, int j) {
        int sum=0;
        while(i>0){
            sum = sum+i%10;
            i = i/10;
        }
        while(j>0){
            sum = sum+j%10;
            j = j/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        RobotScope rp = new RobotScope();
//        System.out.println(rp.getTempSum(1,2));
        System.out.println(rp.movingCount(5,10,10));
    }
}
