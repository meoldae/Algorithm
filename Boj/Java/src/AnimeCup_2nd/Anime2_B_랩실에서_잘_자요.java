package AnimeCup_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anime2_B_랩실에서_잘_자요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] pages = new int[n + 1];
        String[] input = br.readLine().split(" ");
        int first = Integer.MAX_VALUE;
        int last = 0;
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(input[i]);
            pages[now] = 1;
            first = Math.min(first, now);
            last = Math.max(last, now);
        }
        int answer = 0;
        int print = 0;
        int exist = 0;
        for (int i = 1; i <= n; i++) {

            if (pages[i] == 1) {
                if (exist >= 2 && print - exist > 0) {
                    answer += 5 + 2 * (print - exist + 1);
                    exist = 0;
                    print = 0;
                    continue;
                }
                if (print != 0){
                    print++;
                }
                exist++;
            } else {
                exist = 0;
                print++;
            }
        }
        if (print - exist > 0) {
            answer += 5 + 2 * (print - exist);
        }
        System.out.println(answer);
    }
}
