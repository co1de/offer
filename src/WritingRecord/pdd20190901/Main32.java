package WritingRecord.pdd20190901;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.ArrayList;
import java.util.Scanner;

public class Main32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        int count = 0;
        int two = 0;
        while (count < k) {
            if ((n-count)==(m-count)){
                list.add((long) (n-count)*(m-count));
                count++;
            }
            while (two < 2) {
                if ((n - count != m) || (m - count != n)) {
                    if (two == 1) {
                        list.add((long) Math.min((n - count) * m, (m - count) * n));
                        two++;
                    } else if (two == 0) {
                        list.add((long) Math.max((n - count) * m, (m - count) * n));
                        two++;
                    } else {
//                    two = 0;
                        count++;
                    }
                }
            }
            two=0;


        }
        System.out.println(list.get(k-1));
    }
}
