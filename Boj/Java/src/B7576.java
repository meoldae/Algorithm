import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] storage = new int[N][M];

        for (int i = 0; i < N; i++) {
            storage[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (storage[i][j] == 1) queue.offer(new int[]{i, j, 0});
            }
        }

        int answer = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            answer = Math.max(answer, now[2]);

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (storage[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny, now[2] + 1});
                        storage[nx][ny] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (storage[i][j] == 0){
                    System.out.print(-1);
                    return;
                }
            }
        }
        System.out.print(answer);
    }
}
