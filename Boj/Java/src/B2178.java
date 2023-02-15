import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == m - 1) {
                System.out.println(now[2]);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < n && 0 <= ny && ny < m){
                    if (!visited[nx][ny]){
                        if (board[nx][ny] == '1'){
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny, now[2]+1});
                        }
                    }
                }
            }
        }
    }
}
