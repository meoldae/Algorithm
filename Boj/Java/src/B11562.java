import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] roads = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(roads[i], Integer.MAX_VALUE);
            roads[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            roads[u][v] = 0;
            roads[v][u] = 1;
            if (b == 1) roads[v][u] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (roads[j][i] != Integer.MAX_VALUE && roads[i][k] != Integer.MAX_VALUE) {
                        roads[j][k] = Math.min(roads[j][k], roads[j][i] + roads[i][k]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(roads[s][e]).append("\n");
        }
        System.out.print(sb);
    }
}
