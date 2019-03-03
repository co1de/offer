package newcode;

/**
 * 题目描述
 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * */

public class MatrixPath {
    public static void main(String[] args) {
        char[] test = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str = {'b','c','c','e','d'};
        char[] str2 = {'a','b','c','b'};
        System.out.println(hasPath(test,3,4,str2));
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        boolean flag = false;
        //构建二维矩阵
        char[][] middle = new char[rows][cols];
        int k=0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                middle[i][j]=matrix[k++];
            }
        }

        //在矩阵中查找首字母位置
        boolean[][] mark = new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (middle[i][j]== str[0]){
                    if (judgePath(middle,mark,i,j,0,str)){
                        return true;
                    }
                }
            }
        }

        return flag;
    }

    private static boolean judgePath(char[][] middle, boolean[][] mark,int i,int j,int pathLen,char[] str) {
        //按上下左右的顺序判断
        mark[i][j]= true;
        //最后一次，已经到底了，返回条件
        if (middle[i][j] == str[pathLen] && pathLen == str.length-1){
            return true;
        }
        //可以向左
        if (j-1>=0 && mark[i][j-1]!=true){
            if (middle[i][j-1] == str[pathLen+1]){
                if (judgePath(middle,mark,i,j-1,pathLen+1,str)){
                    return true;
                }
            }
        }
        //可以向右
        if (j+1<middle[0].length && mark[i][j+1] != true){
            if (middle[i][j+1] == str[pathLen+1]){
                if (judgePath(middle,mark,i,j+1,pathLen+1,str)){
                    return true;
                }
            }
        }
        //可以向上
        if (i-1>=0 && mark[i-1][j] != true){
            if (middle[i-1][j] == str[pathLen+1]){
                if (judgePath(middle,mark,i-1,j,pathLen+1,str)){
                    return true;
                }
            }
        }
        //可以向下
        if (i+1<middle.length && mark[i+1][j] != true){
            if (middle[i+1][j] == str[pathLen+1]){
                if (judgePath(middle,mark,i+1,j,pathLen+1,str)){
                    return true;
                }
            }
        }
        //都走不通记得清除标记数组状态，否则会影响下次查找。这里最容易出问题。。
        mark[i][j] =false;
        return false;
    }
}
