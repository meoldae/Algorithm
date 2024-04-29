import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2876 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] desks = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            desks[i][0] = Integer.parseInt(st.nextToken());
            desks[i][1] = Integer.parseInt(st.nextToken());
        }

        int maxStudentCount = 0;
        int minGrade = 5;
        int[][] dp = new int[N + 1][6];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 5; j++) {
                int[] desk = desks[i - 1];
                if (desk[0] == j || desk[1] == j) {
                    dp[i][j] = dp[i - 1][j] + 1;
                    if (maxStudentCount < dp[i][j]) {
                        maxStudentCount = dp[i][j];
                        minGrade = j;
                    } else if (maxStudentCount == dp[i][j]) {
                        minGrade = Math.min(minGrade, j);
                    }
                }
            }
        }
        System.out.print(maxStudentCount + " " + minGrade);
    }
}
