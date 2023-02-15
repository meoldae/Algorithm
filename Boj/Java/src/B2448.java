import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2448 {
    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][(n * 2) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ' ');
        }
        makeStar(0, n - 1, n);

        for (char[] arr : board) {
            for (char star : arr) {
                sb.append(star);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void makeStar(int x, int y, int depth) {
        if (depth == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = '*';
            board[x + 1][y + 1] = '*';
            board[x + 2][y - 1] = '*';
            board[x + 2][y] = '*';
            board[x + 2][y + 1] = '*';
            board[x + 2][y - 2] = '*';
            board[x + 2][y + 2] = '*';
            return;
        }
        makeStar(x, y, depth / 2);
        makeStar(x + depth / 2, y - depth / 2, depth / 2);
        makeStar(x + depth / 2, y + depth / 2, depth / 2);
    }
}
