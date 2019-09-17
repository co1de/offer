package WritingRecord.kuaishou20190916;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        System.out.println(judgeIP(ip));
    }

    private static String judgeIP(String ip) {
        String ret = "Neither";
        if (ip==null) return ret;
        if (ip.endsWith(".")) {
            return "Neither";
        }
        if (!ip.contains(".") && !ip.contains(":")) {
            return ret;
        }
        if (ip.contains(".")) {
            if (ip.endsWith(".")) {
                return "Neither";
            }
            String[] arr = ip.split("\\.");

            if (arr.length != 4) {
                return ret;
            }
            for (int i = 0; i < 4; i++) {
                if (arr[i].length() < 3) {
                    return ret;
                }
                //判断字符合法性
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) < '9') {
                        continue;
                    }else return ret;
                }
                //验证数字段合法性
                if (Integer.valueOf(arr[i]) > 255 || (arr[i].length()>=2 && String.valueOf(arr[i]).startsWith("0"))) {
                    return ret;
                }
            }
            ret = "IPv4";
        }
        if (ip.contains(":")) {
            if (ip.endsWith(":") && !ip.endsWith("::")) {
                return "Neither";
            }
            if (ip.indexOf("::") != -1 && ip.indexOf("::", ip.indexOf("::")+ 2) != -1) {
                return "Neither";

            }
            if (ip.contains("::")) {
                String[] arr = ip.split(":");
                if (arr.length>7 || arr.length<1) return "Neither";
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals("")) continue;
                    if (arr[i].length()>4) return "Neither";
                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) < '9' || arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f' || arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F') {
                            continue;
                        } else {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
            if (!ip.contains("::")) {
                String[] arr = ip.split(":");
                if (arr.length!=8) return "Neither";
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].length()>4) return "Neither";
                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) >= '0' && arr[i].charAt(j) < '9' || arr[i].charAt(j) >= 'a' && arr[i].charAt(j) <= 'f' || arr[i].charAt(j) >= 'A' && arr[i].charAt(j) <= 'F') {
                            continue;
                        } else {
                            return "Neither";
                        }
                    }
                }
                return "IPv6";
            }
        }
        return ret;
    }
}
