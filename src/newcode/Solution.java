package newcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.*;

public class Solution {

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number, 0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }



    public static void main(String[] args) {
        String s = "C/KZl4ErlJxwcJsXHTEViyBzDg5z,ORSCgJqm6+4Xj6sJBdOc1Z+OAgKO";
        String s2 = "C/KZl4ErlJxwcJsXHTEViyBzDg5z,ORSCgJqm6+4Xj6sJBdOc1Z+OAgKO";
//        StringBuffer
//                StringBuilder

        if (s.equals(s2)){
            System.out.println("yes!");
        }
//        ThreadFactory factory = new ThreadFactoryBuilder();execu
        ExecutorService service = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
//        s.wait();
    }

    class testCallable implements Callable{


        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Object call() throws Exception {
            return null;
        }
    }


}
