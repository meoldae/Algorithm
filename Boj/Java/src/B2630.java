import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2630 {
    static int[][] board;
    static int[] paper = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        divide(0, 0, n);
        System.out.println(paper[0]);
        System.out.print(paper[1]);
    }

    static void divide(int x, int y, int n) {
        int flag = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != flag) {
                    divide(x, y, n / 2);                       // 1
                    divide(x, y + n / 2, n / 2);            // 2
                    divide(x + n / 2, y, n / 2);            // 3
                    divide(x + n / 2, y + n / 2, n / 2); // 4
                    return;
                }
            }
        }
        paper[flag]++;
    }
}
