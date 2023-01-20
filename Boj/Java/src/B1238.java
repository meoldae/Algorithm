import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n, m, x;
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = Integer.parseInt(input[2]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k || graph[j][i] == Integer.MAX_VALUE || graph[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            if (i == x-1 || graph[i][x-1] == Integer.MAX_VALUE) {
                continue;
            }
            maxVal = Math.max(graph[i][x-1] + graph[x-1][i], maxVal);

        }
        System.out.println(maxVal);
    }
}