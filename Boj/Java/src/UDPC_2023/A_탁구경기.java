package UDPC_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_탁구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int d = 0;
        int p = 0;
        for (int i = 0; i < N; i++){
            String input = br.readLine().trim();
            if (input.equals("D")) d++;
            else p++;
            if (Math.abs(d - p) >= 2) {
                System.out.print(d+":"+p);
                return;
            }
        }
        System.out.print(d+":"+p);
    }
}
