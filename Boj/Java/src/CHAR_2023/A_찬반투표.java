package CHAR_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_찬반투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] vote = new int[3];
        Arrays.stream(br.readLine().split(" ")).forEach(num -> vote[Integer.parseInt(num) + 1]++);
        if (vote[1]*2 >= N) System.out.print("INVALID");
        else if (vote[2] > vote[0]) System.out.print("APPROVED");
        else System.out.print("REJECTED");
    }
}
