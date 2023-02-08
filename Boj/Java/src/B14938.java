import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                board[i][j] = -1;
            }
        }
        int[] items = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            if (board[s][e] == -1) board[s][e] = cost;
            else board[s][e] = Math.min(board[s][e], cost);

            if (board[e][s] == -1) board[e][s] = cost;
            else board[e][s] = Math.min(board[e][s], cost);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) continue;
                    if (board[j][i] != -1 && board[i][k] != -1) {
                        if (board[j][k] == -1) {
                            board[j][k] = board[j][i] + board[i][k];
                        }else {
                            board[j][k] = Math.min(board[j][k], board[j][i] + board[i][k]);
                        }
                    }
                }
            }
        }
        int answer = 0;
        for (int[] area : board) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (0 <= area[i] && area[i] <= m) sum += items[i];
            }
            answer = Math.max(answer, sum);
        }
        System.out.println(answer);
    }
}
