package WritingRecord.toutiao0908;

import java.util.ArrayList;
import java.util.Scanner;

public class Translate {
    private ArrayList<String> ret = new ArrayList<>();
    private static String[] yingshe = {"A", "B", "C", "D", "E",
            "F", "G", "H", "I", "G",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y",
            "Z"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <=1; j++) {
                if (i + j <= s.length()) {
                    translate(s.substring(i,i+j));
                }
            }
            System.out.println();
        }
    }

    private static void translate(String substring) {
        if (substring.length() == 1) {
            int c = Integer.valueOf(substring);
//            System.out.println(c);
            System.out.print(yingshe[c-1]);
        } else if (substring.length() == 2){
            int c = Integer.valueOf(substring);
            System.out.print(yingshe[c-1]);
        }
    }
}
