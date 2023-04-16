package AGCU_1st;

import java.util.Scanner;

public class C_고양이는_많을수록_좋다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long start = 0;
        int count = 0;
        while (start < x) {
            if (start == 0) start += 1;
            else start *= 2;
            count++;
        }
        System.out.print(count);
    }
}
