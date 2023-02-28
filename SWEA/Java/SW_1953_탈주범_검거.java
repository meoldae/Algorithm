import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1953_탈주범_검거 {
    static int[][] direction = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {3, 0}};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startX, startY, 1});
            visited[startX][startY] = 1;
            int answer = 1;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (now[2] == time) break;
                for (int d : direction[board[now[0]][now[1]]]) {
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (visited[nx][ny] == 0 && isPossible(now[0], now[1], d)) {
                            visited[nx][ny] = 1;
                            answer++;
                            queue.offer(new int[]{nx, ny, now[2] + 1});
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static boolean isPossible(int x, int y, int d) {
        int nextType = board[x + dx[d]][y + dy[d]];
        if (nextType == 0) return false;
        for (int next : direction[nextType]) {
            if ((d + 2) % 4 == next) return true;
        }
        return false;
    }
}
