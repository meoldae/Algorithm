import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][N];

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) cost[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++){
            cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
            cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + cost[i][1];
            cost[i][2] = Math.min(cost[i-1][0], cost[i-1][1]) + cost[i][2];
        }
        System.out.print(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
    }
}
