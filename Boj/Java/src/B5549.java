import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5549 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[][][] land = new int[3][M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k < 3; k++) {
                    land[k][i][j] = land[k][i - 1][j] + land[k][i][j - 1] - land[k][i - 1][j - 1];                    
                }                    

                if (input[j - 1] == 'J') {
                    land[0][i][j]++;
                } else if (input[j - 1] == 'O') {
                    land[1][i][j]++;
                } else if (input[j - 1] == 'I') {
                    land[2][i][j]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                int answer = land[j][x2][y2] - land[j][x1 - 1][y2] - land[j][x2][y1 - 1] + land[j][x1 - 1][y1 - 1];
                sb.append(String.valueOf(answer)).append(" ");    
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}