import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B17136 {
    static final int BOARD_SIZE = 10;
    static int[][] board;
    static boolean[][] visited;
    static int[] paper;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[BOARD_SIZE][BOARD_SIZE];
        visited = new boolean[BOARD_SIZE][BOARD_SIZE];
        paper = new int[6];
        Arrays.fill(paper, 5);

        for (int i = 0; i < BOARD_SIZE; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        backTrack(0, 0, 0);

        System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
    }

    static void backTrack(int x, int y, int paperCount) {
        if (x == BOARD_SIZE - 1 && y == BOARD_SIZE) {
            answer = Math.min(answer, paperCount);
            return;
        }
        if (answer <= paperCount) return;

        if (y == BOARD_SIZE) {
            backTrack(x + 1, 0, paperCount);
            return;
        }

        if (visited[x][y] || board[x][y] == 0) {
            backTrack(x, y + 1, paperCount);
            return;
        }

        for (int p = 5; p > 0; p--) {
            if (paper[p] > 0 && isCover(x, y, p)) {
                paper[p]--;
                cover(x, y, p, true);
                backTrack(x, y + p, paperCount + 1);
                cover(x, y, p, false);
                paper[p]++;
            }
        }
    }

    static boolean isCover(int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (x + i >= BOARD_SIZE || y + j >= BOARD_SIZE || board[x + i][y + j] == 0 || visited[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void cover(int x, int y, int n, boolean flag) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[x + i][y + j] = flag;
            }
        }
    }
}