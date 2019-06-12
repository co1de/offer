import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private int test;
    public int test(){
        return test;
    }

    public static void main(String args[]) {

        Main t = new Main();
        int a = t.test;
        t.test();
        String s = "abcdefghijk";
        System.out.println(s.substring(0,3));
    }
}