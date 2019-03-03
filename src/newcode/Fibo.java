package newcode;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * */
public class Fibo {
    public static void main(String[] args) {

    }
    public static int Fibonacci(int n) {

        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        //尾递归防止溢出
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
