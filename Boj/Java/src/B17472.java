import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17472 {
    static int N, M, islandNo;
    static int[][] board;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<int[]> pq;
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        islandNo = 1;
        board = new int[N][M];
        visited = new int[N][M];
        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0 && board[i][j] == 1) {
                    visited[i][j] = islandNo;
                    checkIsland(i, j);
                }
            }
        }

        bridgeCheck();

        p = new int[islandNo - 1];
        for (int i = 0; i < islandNo - 1; i++) p[i] = i;

        makeMST();
    }

    static void checkIsland(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (visited[nx][ny] == 0 && board[nx][ny] == 1) {
                        visited[nx][ny] = islandNo;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        islandNo++;
    }

    static void bridgeCheck() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                for (int d = 0; d < 4; d++) {
                    getBridgeLength(i, j, d);
                }
            }
        }
    }

    static void getBridgeLength(int x, int y, int d) {
        int src = visited[x][y];
        int length = 0;
        while (true) {
            if (visited[x][y] != 0 && visited[x][y] != src){
                if (length >= 3) pq.offer(new int[]{src - 1, visited[x][y] - 1, length - 1});
                return;
            }

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny] == src) return; // 범위 벗어남

            length++;
            x = nx;
            y = ny;
        }
    }

    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (!isSameParent(x, y)) {
            if (x <= y) p[y] = x;
            else p[x] = y;
        }
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    static void makeMST() {
        int answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (!isSameParent(now[0], now[1])) {
                union(now[0], now[1]);
                answer += now[2];
                count++;
            }
        }

        if (count == islandNo - 2) System.out.print(answer);
        else System.out.print(-1);
    }
}
