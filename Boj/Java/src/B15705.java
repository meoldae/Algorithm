import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B15705 {
    private static char[] target;
    private static int N, M;
    private static char[][] board;
    private static boolean flag = false;
    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        target = br.readLine().toCharArray();
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        for (int d = 0; d < 8; d++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (flag) {
                        System.out.println(1);
                        return;
                    }
                    int endX = x + (dx[d] * target.length);
                    int endY = y + (dy[d] * target.length);
                    if (endX < 0 || endX >= N || endY < 0 || endY >= M) {
                        continue;
                    }
                    hasWord(x, y, d);
                }
            }
        }
        System.out.println(0);
    }

    private static void hasWord(int x, int y, int d) {
        for (int i = 0; i < target.length; i++) {
            if (board[x + (dx[d] * i)][y + (dy[d] * i)] != target[i]) {
                return;
            }
        }
        flag = true;
    }
}
