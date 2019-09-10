import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        while (sc.hasNextLine()) {
            if (sc.nextLine().equals("\n")) {
                break;
            } else {
                System.out.println("hh");
            }
        }
    }


}