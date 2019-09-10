import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //两张满m减免的优惠券
        int count =2;
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<Integer> list = new ArrayList<>();
        String line = sc.nextLine();
        String[] words = line.split(" ");
        for (String word:words) {
            list.add(Integer.valueOf(word));
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        int left=0;
        int right = arr.length - 1;
        int curMax=0;
        while (left<right) {
            //找到最小的
            while (arr[left] == 0) {
                left++;
            }
            if (arr[left] >= m) {
                curMax += arr[left];
                arr[left]=0;
                count--;
                left++;
            }
            //找到最大的
            while (arr[left] + arr[right] >= m) {
                right--;
            }
            right++;
            if (arr[left] + arr[right] >= m) {
                curMax += arr[left] + arr[right];
                arr[left]=0;
                arr[right]=0;
                count--;
                left++;
                right--;
            }
            if (count == 0) {
                break;
            }
            Arrays.sort(arr);
            right=arr.length-1;
        }
        DecimalFormat df = new DecimalFormat("0.0");
        if (curMax == 0) {
            curMax=-1;
        }
        System.out.println(df.format(curMax));
     }
}
