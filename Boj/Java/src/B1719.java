import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1719 {
    static int[][] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N + 1][N + 1];
        path = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i + 1], Integer.MAX_VALUE);
            graph[i + 1][i + 1] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[src][dst] = cost;
            graph[dst][src] = cost;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if (j == k) continue;
                    if (graph[j][i] == Integer.MAX_VALUE || graph[i][k] == Integer.MAX_VALUE) continue;
                    if (graph[j][k] > graph[j][i] + graph[i][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                        path[j][k] = i;
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) sb.append("-").append(" ");
                else {
                    sb.append(getPath(i, j)).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int getPath(int start, int end) {
        if (path[start][end] == 0) return end;
        else return getPath(start, path[start][end]);
    }
}