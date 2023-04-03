package PACKAGE_NAME;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D6_1263_사람_네트워크2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] graph = new int[N][N];
            int i = 0;
            int j = 0;
            while (st.hasMoreTokens()) {
                graph[i][j++] = Integer.parseInt(st.nextToken());
                if (j == N) {
                    i++;
                    j = 0;
                }
            }
            for (int a = 0; a < N; a++) {
                for (int b = 0; b < N; b++) {
                    for (int c = 0; c < N; c++) {
                        if (b == c) continue;
                        if (graph[b][a] != 0 && graph[a][c] != 0) {
                            graph[b][c] = graph[b][c] == 0 ? graph[b][a] + graph[a][c] : Math.min(graph[b][c], graph[b][a] + graph[a][c]);
                        }
                    }
                }
            }
            int answer = Integer.MAX_VALUE;
            for (int row = 0; row < N; row++) {
                answer = Math.min(answer, Arrays.stream(graph[row]).sum());
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}