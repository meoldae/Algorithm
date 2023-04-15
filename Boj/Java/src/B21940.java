import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];

        for (int[] row : graph) Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph[src][dst] = cost;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k || graph[j][i] == Integer.MAX_VALUE || graph[i][k] == Integer.MAX_VALUE) continue;
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int K = Integer.parseInt(br.readLine());
        int[] friends = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) friends[i] = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<Integer> answer = new PriorityQueue<>();
        int maxVal = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int distance = 0;
            for (int j : friends) distance = Math.max(distance, graph[i][j] + graph[j][i]);

            if (distance < maxVal) {
                maxVal = distance;
                answer.clear();
                answer.offer(i + 1);
            }
            else if (distance == maxVal) answer.offer(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()) sb.append(answer.poll()).append(" ");
        System.out.print(sb);
    }
}
