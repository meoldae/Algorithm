import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B16985 {
    static int SIZE = 5;
    static int[][][] grid;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int answer = Integer.MAX_VALUE;

    static List<int[]> repeatedPerm = new ArrayList<>();
    static int[] selected1 = new int[SIZE];

    static List<int[]> order = new ArrayList<>();
    static boolean[] isSelected = new boolean[SIZE];
    static int[] selected2 = new int[SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        grid = new int[SIZE][SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < SIZE; k++) {
                    grid[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }
        permWithRepeat(0);
        perm(0);

        for (int[] turn : repeatedPerm) {
            int[][][] copied = copyArr();
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < turn[i]; j++) {
                    turn(copied[i]);
                }
            }

            for (int[] stack : order) {
                int[][][] stacked = new int[SIZE][][];
                for (int i = 0; i < SIZE; i++) {
                    stacked[i] = copied[stack[i]];
                }
                if (stacked[0][0][0] == 1) {
                    answer = Math.min(answer, bfs(stacked));
                }
            }

        }
        System.out.print(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static int[][][] copyArr() {
        int[][][] copied = new int[SIZE][SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < SIZE; k++) {
                    copied[i][j][k] = grid[i][j][k];
                }
            }
        }
        return copied;
    }

    public static void permWithRepeat(int count) {
        if (count == SIZE) {
            repeatedPerm.add(new int[]{selected1[0], selected1[1], selected1[2], selected1[3], selected1[4]});
            return;
        }

        int turnCoef = 4;
        for (int i = 0; i < turnCoef; i++) {
            selected1[count] = i;
            permWithRepeat(count + 1);
        }
    }

    public static void perm(int count) {
        if (count == SIZE) {
            order.add(new int[]{selected2[0], selected2[1], selected2[2], selected2[3], selected2[4]});
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selected2[count] = i;
            perm(count + 1);
            isSelected[i] = false;
        }
    }


    public static void turn(int[][] row) {
        int[][] tempGrid = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                tempGrid[j][SIZE - i - 1] = row[i][j];
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                row[i][j] = tempGrid[i][j];
            }
        }
    }

    public static int bfs(int[][][] copied) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, 0, 0});
        boolean[][][] visited = new boolean[SIZE][SIZE][SIZE];
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == SIZE - 1 && now[1] == SIZE - 1 && now[2] == SIZE - 1) {
                return now[3];
            }

            for (int d = 0; d < 6; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                int nz = now[2] + dz[d];

                if (0 > nx || nx >= SIZE || 0 > ny || ny >= SIZE || 0 > nz || nz >= SIZE) continue;
                if (visited[nz][nx][ny]) continue;
                if (copied[nz][nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, nz, now[3] + 1});
                    visited[nz][nx][ny] = true;
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
