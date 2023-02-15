import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1861_정사각형_방 {
    static int[][] board;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            for (int i = 0; i < n; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int maxVal = 0;
            int answerLocation = Integer.MAX_VALUE;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int result = bfs(x, y);
                    if (maxVal < result) {
                        maxVal = result;
                        answerLocation = board[x][y];
                    }else if(maxVal == result){
                        if (board[x][y] < answerLocation){
                            answerLocation = board[x][y];
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(answerLocation).append(" ").append(maxVal).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        boolean[][] visited = new boolean[n][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int maxVal = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            maxVal = Math.max(maxVal, now[2]);

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (!visited[nx][ny]){
                        if (board[nx][ny] == board[now[0]][now[1]]+1){
                            queue.offer(new int[]{nx, ny, now[2]+1});
                        }
                    }
                }
            }
        }
        return maxVal;
    }
}
