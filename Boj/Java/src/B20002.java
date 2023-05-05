import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sums = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sums[i + 1][j + 1] = board[i][j] + sums[i][j + 1] + sums[i + 1][j] - sums[i][j];
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int k = 1; k <= N; k++) {
            for (int r = 0; r <= N - k ; r++) {
                for (int c = 0; c <= N - k ; c++) {
                    int sum = sums[r + k][c + k] - sums[r][c + k] - sums[r + k][c] + sums[r][c];
                    answer = Math.max(answer, sum);

                }
            }
        }
        System.out.print(answer);
    }
}
