import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D2_2001_파리_퇴치 {
    static int n, m;
    static int[][] flies;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            flies = new int[n][n];
            for (int i = 0; i < n; i++){
                flies[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            int answer = 0;
            for (int i = 0; i <= n-m; i++){
                for (int j = 0; j <= n-m; j++){
                    answer = Math.max(answer, smash(i, j));
                }
            }
            System.out.printf("#%d %d%n", tc, answer);
        }
    }

    static int smash(int row, int col) {
        int sum = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                sum += flies[i+row][j+col];
            }
        }
        return sum;
    }
}
