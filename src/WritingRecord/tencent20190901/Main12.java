package WritingRecord.tencent20190901;

import java.util.Scanner;

public class Main12 {
    private static int curCount;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        while (count < t) {
            int start =sc.nextInt();
            int end = sc.nextInt();

            for (int i = start; i <= end; i++) {
                int curWhite = 0;
                int curRed = 0;
                for (int j = 0; j*k < start; j++) {
                    String s = "";

                    curWhite = j*k;
                    curRed = start-curWhite;
                    for (int l = 0; l < curRed; l++) {
                        s+="r";
                    }
                    if (curWhite != 0) {
                        s += "w";
                    }
                    compute(s.toCharArray(),0,s.length()-1);
                }
            }
            System.out.println((curCount+1)%(1000000007));
            count++;
        }
    }

    private static void compute(char[] c,int start, int end) {
        if (start == end) {
            curCount++;
        } else {
            for (int i = start; i < c.length; i++) {
                swap(c, i, start);
                compute(c, start + 1, end);
                swap(c,i,start);
            }
        }
    }

    public static void swap(char[] arrayA,int m,int n){
        char temp = arrayA[m];
        arrayA[m] = arrayA[n];
        arrayA[n] = temp;
    }
}
