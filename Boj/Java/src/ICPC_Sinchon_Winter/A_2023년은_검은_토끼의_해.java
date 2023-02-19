package ICPC_Sinchon_Winter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_2023년은_검은_토끼의_해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        if (n < 2023) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i <= n; i++) {
            if (lottery(i)) count++;
        }
        System.out.println(count);
    }

    static boolean lottery(int num) {
        char[] serial = String.valueOf(num).toCharArray();
        int idx = 0;
        char[] win = new char[]{'2', '0', '2', '3'};
        for (char s : serial) {
            if (s == win[idx]) idx++;
            if (idx == 4) return true;
        }
        return false;
    }
}
