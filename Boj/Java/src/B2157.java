import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] lines = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a > b) continue;

            lines[a][b] = Math.max(lines[a][b], c);
        }

        int[][] scores = new int[M + 1][N + 1];
        for (int[] score : scores) Arrays.fill(score, -1);
        scores[1][1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (scores[j][i] == -1) continue;

                for (int k = i + 1; k <= N; k++) {
                    if (lines[i][k] == 0) continue;
                    scores[j + 1][k] = Math.max(scores[j + 1][k], scores[j][i] + lines[i][k]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= M; i++) {
            answer = Math.max(scores[i][N], answer);
        }

        System.out.print(answer);
    }
}
