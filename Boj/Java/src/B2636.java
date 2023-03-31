import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2636 {
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        int cheese = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) cheese++;
            }
        }
        int time = 0;
        while(true) {
            List<int[]> del = contactAir(board);
            answer = cheese;
            for (int [] loc : del) board[loc[0]][loc[1]] = 0;
            cheese -= del.size();
            time++;
            if (cheese == 0) break;
        }
        System.out.println(time);
        System.out.print(answer);
    }

    static List<int[]> contactAir(int[][] board){
        List<int[]> result = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 > nx || N <= nx || 0 > ny || M <= ny) continue;
                if (visited[nx][ny]) continue;
                if (board[now[0]][now[1]] == 0 && board[nx][ny] == 1) result.add(new int[]{nx, ny});
                else if (board[nx][ny] == 0) queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
        return result;
    }
}
