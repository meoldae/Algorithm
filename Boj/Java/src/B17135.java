import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17135 {
    static int N, M, D;
    static int[][] board, hunted, tempBoard;
    static int[] selected = new int[3];
    static List<int[]> archers = new ArrayList<>();
    static int answer;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        comb(0, 0);

        for (int[] archer : archers) {
            copyBoard(board);
            hunted = new int[N + 1][M];
            for (int i = 0; i < N; i++) {
                int[][] killed = new int[3][];
                for (int j = 0; j < 3; j++) {
                    killed[j] = hunt(archer[j], D);
                }
                for (int[] killedLoca : killed) {
                    if (killedLoca != null) tempBoard[killedLoca[0]][killedLoca[1]] = 0;
                }
                tempBoard = Arrays.copyOf(tempBoard, tempBoard.length - 1); // Turn 끝 한칸 자름
                Arrays.fill(tempBoard[tempBoard.length - 1], 0);
            }
            int maxMonster = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    maxMonster += hunted[i][j];
                }
            }
            answer = Math.max(answer, maxMonster);
        }
        System.out.print(answer);
    }

    static void copyBoard(int[][] board) {
        tempBoard = new int[N + 1][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
    }

    static void comb(int count, int start) {
        if (count == 3) {
            archers.add(new int[]{selected[0], selected[1], selected[2]});
            return;
        }
        for (int i = start; i < M; i++) {
            selected[count] = i;
            comb(count + 1, i + 1);
        }
    }

    static int[] hunt(int archer, int dist) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[tempBoard.length][M];
        queue.offer(new int[]{tempBoard.length - 1, archer, dist});
        visited[tempBoard.length - 1][archer] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (tempBoard[now[0]][now[1]] == 1) {
                hunted[now[0]][now[1]] = 1;
                return new int[]{now[0], now[1]};
            }

            for (int d = 0; d < 3; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && 0 <= ny && ny < M) {
                    if (visited[nx][ny] || now[2] == 0) continue;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, now[2] - 1});
                }
            }
        }
        return null;
    }
}
