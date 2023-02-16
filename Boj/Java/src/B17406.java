import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17406 {
    static int N, M, K;
    static int[][] board;
    static int[][] copied;
    static ArrayList<int[]> list;
    static boolean[] visited;
    static int[] permResult;

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][];
        visited = new boolean[K];
        list = new ArrayList<>();
        permResult = new int[K];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] command = new int[K][];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            command[i] = new int[]{x, y, s};
        }
        perm(0);
        int answer = Integer.MAX_VALUE;

        for (int[] com : list) {
            copied = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copied[i][j] = board[i][j];
                }
            }
            for (int c : com) {
                int x = command[c][0];
                int y = command[c][1];
                int s = command[c][2];
                rotate(x - s, y - s, s);
            }
            for (int[] row : copied) {
                answer = Math.min(answer, Arrays.stream(row).sum());
            }
        }
        System.out.println(answer);
    }

    static void perm(int count) {
        if (count == K) {
            int[] res = new int[K];
            int cnt = 0;
            for (int i = 0; i < K; i++) {
                if (visited[i]) {
                    res[cnt++] = permResult[i];
                }
            }
            list.add(res);
            return;
        }
        for (int i = 0; i < K; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permResult[count] = i;
            perm(count + 1);
            visited[i] = false;
        }
    }

    static void rotate(int x, int y, int s) throws InterruptedException {
        int[] dx = {1, 0, -1, 0}; // ↓ → ↑ ←
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < s; i++) {
            int d = 0;
            int sx = x + i;
            int sy = y + i;

            int first = copied[sx][sy];
            while (true) {
                int nx = sx + dx[d];
                int ny = sy + dy[d];

                if (x + i <= nx && nx < (x + 2 * s + 1 - i) && y + i <= ny && ny < (y + 2 * s + 1 - i)) {
                    copied[sx][sy] = copied[nx][ny];
                    sx = nx;
                    sy = ny;
                } else {
                    d++;
                    if (d == 4) {
                        break;
                    }
                }
            }
            copied[sx][sy + 1] = first;
        }
    }
}
