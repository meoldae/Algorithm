import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[V][V];
        for (int[] row : graph) Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken()) - 1;
            int dst = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            graph[src][dst] = cost;
        }

        floyd(graph, V);

        int answer = Integer.MAX_VALUE;
        for (int s = 0; s < V; s++) {
            for (int e = 0; e < V; e++){
                if (s == e) continue;
                if (graph[s][e] != Integer.MAX_VALUE && graph[e][s] != Integer.MAX_VALUE) {
                    answer = Math.min(answer, graph[s][e] + graph[e][s]);
                }
            }
        }
        System.out.print((answer != Integer.MAX_VALUE) ? answer : -1);
    }

    static void floyd(int[][] graph, int V){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    if (j == k) {
                        graph[j][k] = 0;
                        continue;
                    }
                    if (graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE){
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    }
                }
            }
        }
    }
}
