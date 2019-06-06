import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static int getMaxValue(int[] weight, int[] value, int w, int n) {
        int[][] table = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[n][w];
    }

    public static int ZeroOnePackage(int []v, int[] s, int C) {
        int[][] M = new int[v.length][C + 1];
        int max = 0;
        for (int i = 0; i < v.length; i++) {
            if (s[i] <= C)
                for (int j = s[i]; j <= C; j++)
                    M[i][j] = v[i];
        }
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j <= C; j++) {
                if (i > 0 && j - s[i] >= 0)
                    M[i][j] = Math.max(M[i - 1][j], M[i - 1][j - s[i]] + v[i]);
                if (M[i][j] > max)
                    max = M[i][j];
            }
        }
//        System.out.println("Max =" + max);
        return max;
    }

    public static int knapsack(int val[], int wt[], int W) {
        int N = wt.length;
        int[][] V = new int[N + 1][W + 1];
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }
        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }
        for (int item=1;item<=N;item++){
            for (int weight=1;weight<=W;weight++){
                if (wt[item-1]<=weight){
                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    V[item][weight]=V[item-1][weight];
                }
            }

        }
        return V[N][W];
    }

    public static void main(String args[]){
//        Scanner scanner = new Scanner(System.in);
//        int totalMoney = scanner.nextInt();
//        scanner.next();
//        int[] perPrice = new int[100];
//        int sum = 0;
//        while (scanner.hasNextInt()) {
//            perPrice[sum++] = scanner.nextInt();
//        }
//        scanner.next();
//        int[] perHot = new int[sum];
//        while (scanner.hasNextInt()) {
//            perHot[sum++] = scanner.nextInt();
//        }
        int n = 1, w = 1000;                    //物品个数，背包容量
        int[] value = {6, 10, 3, 4, 5, 8};     //各个物品的价值
        int[] weight = {200, 600, 100, 180, 300, 450};    //各个物品的重量
//        System.out.println(getMaxValue(weight,value,w,n));
//        System.out.println(ZeroOnePackage(value,weight,w));
//        System.out.println(knapsack(value,weight,w));

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(6);
        list1.add(8);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(4);

        list1.removeAll(list2);
        for (Integer integer : list1) {
            System.out.print(integer+" ");
        }
    }


}