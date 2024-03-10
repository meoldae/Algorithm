import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B17182 {
    static int[][] graph;
    static boolean[] visited;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k) continue;
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        visited[K] = true;
        dfs(K, 1, 0);

        System.out.print(answer);
    }

    public static void dfs(int now, int count, int cost) {
        if (count == N) {
            answer = Math.min(answer, cost);
            return;
        }
        if (cost >= answer) return;

        for (int next = 0; next < N; next++) {
            if (now == next || visited[next]) continue;
            visited[next] = true;
            dfs(next, count + 1, cost + graph[now][next]);
            visited[next] = false;
        }
    }
}