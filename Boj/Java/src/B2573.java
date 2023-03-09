import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2573 {
    static int N, M;
    static int[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int time = 0;
        while (isLump() == 0){
            melt();
            time++;
        }

        if (isLump() > 0) System.out.print(time);
        else System.out.print(0);
    }

    static void melt() {
        int[][] adjOcean = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] > 0){
                    adjOcean[i][j] += isWater(i, j);
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                board[i][j] = (board[i][j] > adjOcean[i][j]) ? board[i][j] - adjOcean[i][j] : 0;
            }
        }
    }

    private static int isWater(int i, int j) {
        int res = 0;
        for (int d = 0; d < 4; d++) if (board[i + dx[d]][j + dy[d]] == 0) res++;
        return res;
    }

    static int isLump(){
        int count = 0;
        int x = 0, y = 0;
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (board[i][j] >= 1) {
                    count++;
                    x = i;
                    y = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            count--;

            for (int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (!visited[nx][ny] && board[nx][ny] >= 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return count;
    }
}
