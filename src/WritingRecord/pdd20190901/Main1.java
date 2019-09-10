package WritingRecord.pdd20190901;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        String[] row = data.split(";");
        String arrData = row[0];
        long n = Long.valueOf(row[1]);
        String[] arr = arrData.split(",");
        long[] arrINT = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrINT[i] = Long.valueOf(arr[i]);
        }
        //ji
        TreeSet<Long> odd = new TreeSet<>();
        //ou
        TreeSet<Long> even = new TreeSet<>();
        odd = (TreeSet<Long>) odd.descendingSet();
        even = (TreeSet<Long>) even.descendingSet();
        for (int i = 0; i < arrINT.length; i++) {
            if (arrINT[i] % 2 == 0) {
                even.add(arrINT[i]);
            } else {
                odd.add(arrINT[i]);
            }
        }
        int count = 0;
        while (count < n) {
            //先偶
            if (even.size() != 0) {
                Iterator<Long> itor = even.iterator();
                while (itor.hasNext()) {
                    System.out.print(itor.next());
                    count++;
                    if (count < n) {
                        if (itor.hasNext()) {
                            System.out.print(",");
                        }
                    }else return;
                }
            }
            System.out.print(",");
            //再奇
            if (odd.size() != 0) {
                Iterator<Long> itor = odd.iterator();
                while (itor.hasNext()) {
                    System.out.print(itor.next());
                    count++;
                    if (count < n) {
                        if (itor.hasNext()) {
                            System.out.print(",");
                        }
                    }else return;
                }
            }
        }


    }
}
