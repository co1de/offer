package WritingRecord.kuaishou20190916;

import java.util.*;

public class Main2 {
    private static ArrayList<String> ret = new ArrayList<>();
    private static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        if (in.length() != 0) {
            recursive("", in);
        }
        Collections.sort(ret);
        System.out.print("[");
        for (int i = 0; i < ret.size(); i++) {
            if (i == ret.size() - 1) {
                System.out.print(ret.get(i));
            } else {
                System.out.print(ret.get(i)+", ");
            }
        }
        System.out.println("]");

    }

    private static void recursive(String s, String in) {
        if (in.length() == 0) {
            ret.add(s);
        } else {
            String num = in.substring(0, 1);
            String words = map.get(num);
            for (int i = 0; i < words.length(); i++) {
                String letter = map.get(num).substring(i, i + 1);
                recursive(s + letter, in.substring(1));
            }
        }
    }
}
