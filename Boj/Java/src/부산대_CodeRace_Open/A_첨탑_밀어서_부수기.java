package 부산대_CodeRace_Open;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_첨탑_밀어서_부수기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        int answer = 1;
        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (next >= now) answer++;
            now = next;
        }
        System.out.print(answer);
    }
}
