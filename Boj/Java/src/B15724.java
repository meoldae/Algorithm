import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15724 {    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] land = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= M; j++) {
                land[i][j] = Integer.parseInt(input[j - 1]) + land[i - 1][j] + land[i][j - 1] - land[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int answer = land[x2][y2] - land[x1 - 1][y2] - land[x2][y1 - 1] + land[x1 - 1][y1 - 1];
            sb.append(String.valueOf(answer)).append("\n");
        }
        System.out.print(sb);
    }
}