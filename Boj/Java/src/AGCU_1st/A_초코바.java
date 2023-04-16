package AGCU_1st;

import java.util.Scanner;

public class A_초코바 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        System.out.print(N*100 >= M ? "Yes" : "No");
    }
}
