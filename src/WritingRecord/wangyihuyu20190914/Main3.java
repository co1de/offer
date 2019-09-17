package WritingRecord.wangyihuyu20190914;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main3 {
    static class Info{
        String date;
        String action;
        String role_id;

        public Info(String date, String action, String role_id) {
            this.date = date;
            this.action = action;
            this.role_id = role_id;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String data) {
            this.date = date;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }
    }

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] dataS = new String[n];
        Info[] data = new Info[n];
        int count= 0;
        sc.nextLine();
        while (count < n) {
            dataS[count++] = sc.nextLine();
        }
        int k=0;
        for (String line:dataS) {
            String date = "";
            String action = "";
            String roleID = "";
            String[] part = line.split(",");
            for (int i = 0; i < part[0].length(); i++) {
                if (date.length() < 19) {
                    if (part[0].charAt(i) != '[' && part[0].charAt(i) != ']') {
                        date += part[0].charAt(i);
                        continue;
                    }
                }
                if (part[0].charAt(i) != '[' && part[0].charAt(i) != ']') {
                    action += part[0].charAt(i);
                }
            }
            String name = part[1].split(":")[1];
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(i) != '"' && name.charAt(i) != '}') {
                    roleID += name.charAt(i);
                }
            }
            data[k++] = new Info(date, action, roleID);
        }

        ArrayList<String> task1User = new ArrayList<>();
        ArrayList<String> task2User = new ArrayList<>();
        ArrayList<String> task3User = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i].getAction().equals("task1")) {
                if (!task1User.contains(data[i].role_id)) {
                    task1User.add(data[i].role_id);
                }
            }
            if (data[i].getAction().equals("task2")) {
                if (!task2User.contains(data[i].role_id)) {
                    task2User.add(data[i].role_id);
                }
            }
            if (data[i].getAction().equals("task3")) {
                if (!task3User.contains(data[i].role_id)) {
                    task3User.add(data[i].role_id);
                }
            }
        }
        int task1Time = 0;
        int task2Time = 0;
        int task3Time = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (!task1User.isEmpty()) {
            for (int i = 0; i < task1User.size(); i++) {
                String endTime="";
                String startTime="";
                int nextStart = 0;
                for (int j = 0; j < data.length; j++) {
//                    if ((!data[j].getAction().equals("task1") && !data[j].getAction().equals("login")) && data[j].getRole_id().equals(task1User.get(i))) {
//                         endTime = data[j].getDate();
//                        if (sdf.parse(endTime).getTime() / 1000 - sdf.parse(startTime).getTime() / 1000 >= 0) {
//                            break;
//                        }
//                    }
                    if (data[j].getAction().equals("task1") && data[j].getRole_id().equals(task1User.get(i))) {
                         startTime = data[j].getDate();
                         nextStart = j;
                         break;
                    }
                }
                for (int j = nextStart; j < data.length; j++) {
                    if ((!data[j].getAction().equals("task1") && !data[j].getAction().equals("login")) && data[j].getRole_id().equals(task1User.get(i))) {
                         endTime = data[j].getDate();
                        if (sdf.parse(endTime).getTime() / 1000 - sdf.parse(startTime).getTime() / 1000 >= 0) {
                            break;
                        }
                    }
                }
                task1Time+=sdf.parse(endTime).getTime()/1000-sdf.parse(startTime).getTime()/1000;

            }
        }

        if (!task2User.isEmpty()) {
            for (int i = 0; i < task2User.size(); i++) {
                String endTime="";
                String startTime="";
                int nextStart = 0;
                for (int j = 0; j < data.length; j++) {
                    if (data[j].getAction().equals("task2") && data[j].getRole_id().equals(task2User.get(i))) {
                        startTime = data[j].getDate();
                        nextStart = j;
                        break;
                    }
                }
                for (int j = nextStart; j < data.length; j++) {
                    if ((!data[j].getAction().equals("task2") && !data[j].getAction().equals("login")) && data[j].getRole_id().equals(task2User.get(i))) {
                        endTime = data[j].getDate();
                        if (sdf.parse(endTime).getTime() / 1000 - sdf.parse(startTime).getTime() / 1000 >= 0) {
                            break;
                        }
                    }
                }
                task2Time+=sdf.parse(endTime).getTime()/1000-sdf.parse(startTime).getTime()/1000;

            }
        }

        if (!task3User.isEmpty()) {
            for (int i = 0; i < task3User.size(); i++) {
                String endTime="";
                String startTime="";
                int nextStart = 0;
                for (int j = 0; j < data.length; j++) {
                    if (data[j].getAction().equals("task2") && data[j].getRole_id().equals(task3User.get(i))) {
                        startTime = data[j].getDate();
                        nextStart = j;
                        break;
                    }
                }
                for (int j = nextStart; j < data.length; j++) {
                    if ((!data[j].getAction().equals("task2") && !data[j].getAction().equals("login")) && data[j].getRole_id().equals(task3User.get(i))) {
                        endTime = data[j].getDate();
                        if (sdf.parse(endTime).getTime() / 1000 - sdf.parse(startTime).getTime() / 1000 >= 0) {
                            break;
                        }
                    }
                }
                task3Time+=sdf.parse(endTime).getTime()/1000-sdf.parse(startTime).getTime()/1000;

            }
        }

        if (!task1User.isEmpty()) {
            System.out.println("task1,"+task1User.size()+","+task1Time);
        }
        if (!task2User.isEmpty()) {
            System.out.println("task2,"+task2User.size()+","+task2Time);
        }
        if (!task3User.isEmpty()) {
            System.out.println("task3,"+task3User.size()+","+task3Time);
        }

    }
}
