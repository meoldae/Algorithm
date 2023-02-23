import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        int[][] visited = new int[N][N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int i = 0; i < N; i++) board[i] = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '1' && visited[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    int numberOfHouse = 0;
                    visited[i][j] = count;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        numberOfHouse++;
                        for (int d = 0; d < 4; d++) {
                            int nx = now[0] + dx[d];
                            int ny = now[1] + dy[d];

                            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                                if (board[nx][ny] == '1' && visited[nx][ny] == 0) {
                                    visited[nx][ny] = count;
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    count++;
                    pq.offer(numberOfHouse);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count - 1).append("\n");
        while (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
        System.out.println(sb);
    }
}

