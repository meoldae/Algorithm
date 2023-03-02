import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_5656_벽돌_깨기 {
    static int N, W, H, answer;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            board = new int[H][W];
            answer = Integer.MAX_VALUE;
            for (int i = 0; i < H; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            shoot(0, board);
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void shoot(int count, int[][] before) {
        if (count == N) {
            answer = Math.min(answer, getCount(before));
            return;
        }
        for (int i = 0; i < W; i++) {
            int[][] after = copy(before);
            int r = hit(i, after);

            if (after[r][i] >= 1) {
                crush(r, i, after);
                down(after);
            }
            shoot(count + 1, after);
        }
    }

    static int hit(int col, int[][] board) {
        for (int r = 0; r < H; r++) {
            if (board[r][col] != 0) {
                return r;
            }
        }
        return 0;
    }

    static void crush(int x, int y, int[][] board) {
        int limit = board[x][y];
        board[x][y] = 0;
        for (int d = 0; d < 4; d++) {
            int count = 1;
            int srcX = x;
            int srcY = y;
            while (count < limit) {
                int nx = srcX + dx[d];
                int ny = srcY + dy[d];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) break;
                if (board[nx][ny] > 1) crush(nx, ny, board);
                board[nx][ny] = 0;
                srcX = nx;
                srcY = ny;

                count++;
            }
        }
    }

    static void down(int[][] board) {
        for (int i = 0; i < W; i++) {
            Queue<Integer> queue = new LinkedList<>();
            for (int j = H - 1; j >= 0; j--) {
                if (board[j][i] != 0) queue.offer(board[j][i]);
            }

            for (int j = H - 1; j >= 0; j--) {
                board[j][i] = (queue.size() > 0) ? queue.poll() : 0;
            }
        }
    }

    private static int getCount(int[][] before) {
        int res = 0;
        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                if (before[i][j] != 0) res++;
            }
        }
        return res;
    }

    static int[][] copy(int[][] before) {
        int[][] after = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                after[i][j] = before[i][j];
            }
        }
        return after;
    }
}
