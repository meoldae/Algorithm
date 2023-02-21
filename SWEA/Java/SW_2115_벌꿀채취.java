import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_2115_벌꿀채취 {
    static int[][] honey, profit;
    static int n, m, c, answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // Test Case
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 벌 통의 크기
            m = Integer.parseInt(st.nextToken()); // 벌 통의 개수
            c = Integer.parseInt(st.nextToken()); // 채취 한도
            answer = 0;                           // 매 테스트 케이스의 정답
            honey = new int[n][n];
            profit = new int[n][n];
            for (int i = 0; i < n; i++)
                honey[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            setProfit();
            setPosition();


            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void setProfit() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                setMaxProfit(i, j, 0, 0, 0);
            }
        }
    }

    static void setMaxProfit(int i, int j, int count, int cSum, int pSum) {
        if (cSum > c) return; // 한도 넘어갔을 때
        if (count == m) {
            profit[i][j - m] = Math.max(profit[i][j - m], pSum);
            return;
        }

        setMaxProfit(i, j + 1, count + 1, cSum, pSum);                                                          // 비 선택
        setMaxProfit(i, j + 1, count + 1, cSum + honey[i][j], pSum + (honey[i][j] * honey[i][j]));  // 선택
    }

    static void setPosition() {
        // 일꾼 2명으로 고정 => 수가 작으므로 반복문 진행
        // 첫 번째 일꾼의 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n - m; j++) {
                // 두 번째 일꾼이 같은 행일 때
                for (int k = j + m; k <= n - m; k++) answer = Math.max(answer, profit[i][j] + profit[i][k]);

                // 두 번째 일꾼이 다른 행일 때
                for (int k = i + 1; k < n; k++) {
                    for (int l = 0; l <= n - m; l++) answer = Math.max(answer, profit[i][j] + profit[k][l]);
                }
            }
        }
    }
}