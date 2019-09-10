package WritingRecord.tencent20190901;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<String> list = new ArrayList<>();
    private static int curCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;
        while (count < t) {
            curCount = 0;
            int start = sc.nextInt();
            int end = sc.nextInt();
            String s = "";
            int white = 0;

            while (start <= end) {
                //init red
                int curLen = 0;
                s="";
                for (int i = 0; i < start; i++) {

                    if (white != 0) {
                        s += "w";
                    }
                    while (white + s.length() < start) {
                        s += "r";
                    }
                    if (white != 0) {
                        curLen = s.length() + white - 1;
                    } else {
                        curLen = s.length()+white;
                    }
                    if (curLen == start) {
//                        compute(s.toCharArray(),start,end);
                        compute(s.toCharArray(), 0, s.length() - 1);
                    }
                    white=(++white)*k;
                }
                start++;
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
