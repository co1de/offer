package WritingRecord.wangyihuyu20190914;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        sc.nextLine();
        while (count < n) {
            String[] lineWords = sc.nextLine().split(" ");
            if (map.get(lineWords[0]) == null) {
                ArrayList<String> value = new ArrayList<>();
                value.add(lineWords[1]);
                map.put(lineWords[0], value);
            } else {
                map.get(lineWords[0]).add(lineWords[1]);
            }
            count++;
        }
        for (Map.Entry<String, ArrayList<String>> out : map.entrySet()) {
            ArrayList<String> outValue = out.getValue();
            for (Map.Entry<String, ArrayList<String>> inner : map.entrySet()) {
                int eqNum = 0;

                ArrayList<String> inValue = null;
                if (!inner.getKey().equals(out.getKey())) {
                    inValue = inner.getValue();
                }else continue;
                HashMap<String, String> temp = new HashMap<>();
                for (int i = 0; i <outValue.size() ; i++) {
                    temp.put(outValue.get(i), null);
                }
                for (int i = 0; i < inValue.size(); i++) {
                    if (temp.containsKey(inValue.get(i))) {
                        eqNum++;
                    }
                }
                if (eqNum > 2) {
                    System.out.println(out.getKey()+" "+inner.getKey()+" "+eqNum);
                }
            }
        }
    }
}

//8
//ddd Kate
//ccc Kate
//ccc Beal
//eee Tom
//ddd Beal
//bbb Kate
//ddd Tom
//ccc Tom