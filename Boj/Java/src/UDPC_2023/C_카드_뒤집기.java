package UDPC_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C_카드_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] order = new int[N];
        int[] card = new int[N];
        boolean flag = true;

        int now = N - 1;
        int o = 1;
        int idx = 0;
        order[0] = 1;
        while (now > 0) {
            card[idx] = now--;
            if (flag) {
                flag = false;
                idx += card[idx];
            }else {
                flag = true;
                idx -= card[idx];
            }
            order[o++] = idx + 1;
        }

        order[idx] = o;
        card[idx] = N;
        StringBuilder sb = new StringBuilder();
        sb.append("YES\n");
        for (int num : card) sb.append(num).append(" ");
        sb.append("\n");

        for (int or : order) sb.append(or).append(" ");

        System.out.print(sb);
    }
}
