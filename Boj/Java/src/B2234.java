import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2234 {
    static int[][] board, visited;
    static int M, N;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> areas;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        visited = new int[M][N];
        areas = new ArrayList<>();

        for (int i = 0; i < M; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int count = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] != 0) continue;
                bfs(i, j, count++);
            }
        }

        sb.append(count - 1).append("\n"); // 방의 갯수
        sb.append(areas.stream().mapToInt(Integer::valueOf).max().orElse(0)).append("\n"); // 가장 넓은 방의 넓이

        int maxVal = 0;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                maxVal = Math.max(maxVal, breakWall(i, j));
            }
        }
        sb.append(maxVal); // 벽을 부쉈을 때 최대 넓이

        System.out.print(sb);
    }

    static void bfs(int x, int y, int number) {
        visited[x][y] = number;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        int area = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            area++;

            for (int d = 0; d < 4; d++){
                if ((board[now[0]][now[1]] & (1 << d)) == 0){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if(visited[nx][ny] == 0){
                        visited[nx][ny] = number;
                        queue.offer(new int[]{nx,  ny});
                    }
                }
            }
        }
        areas.add(area);
    }

    static int breakWall(int i, int j) {
        for (int d = 2; d < 4; d++){
            if ((board[i][j] & (1 << d)) != 0){
                int nx = i + dx[d];
                int ny = j + dy[d];

                if (0 <= nx && nx < M && 0 <= ny && ny < N){
                    if (visited[i][j] != visited[nx][ny]){
                        return areas.get(visited[i][j] - 1) + areas.get(visited[nx][ny] - 1);
                    }
                }
            }
        }
        return 0;
    }
}
