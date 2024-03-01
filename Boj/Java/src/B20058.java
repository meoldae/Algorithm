import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20058 {
    static int[][] grid;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] meltDegree;
    static int iceSize;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        grid = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;
        int biggestIce = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            int l = Integer.parseInt(st.nextToken());

            int[][] tempGrid = new int[size][size];

            for (int x = 0; x < size; x += Math.pow(2, l)) {
                for (int y = 0; y < size; y += Math.pow(2, l)) {
                    turn(x, y, l, tempGrid);
                }
            }

            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    grid[x][y] = tempGrid[x][y];
                }
            }

            meltDegree = new boolean[size][size];
            total = melt(size);

        }

        visited = new boolean[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!visited[x][y] && grid[x][y] > 0) {
                    iceSize = 0;
                    visited[x][y] = true;
                    dfs(x, y, size);
                    biggestIce = Math.max(biggestIce, iceSize);
                }
            }
        }

        System.out.print(total + "\n" + biggestIce);
    }

    public static void turn(int x, int y, int l, int[][] tempGrid) {
        int innerSize = (int) Math.pow(2, l);

        for (int i = 0; i < innerSize; i++) {
            for (int j = 0; j < innerSize; j++) {
                tempGrid[j + y][x + innerSize - i - 1] = grid[y + i][x + j];
            }
        }
    }

    public static int melt(int size) {
        int total = 0;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (0 > nx || nx >= size || 0 > ny || ny >= size) continue;
                    if (grid[nx][ny] > 0) count++;
                }
                if (count >= 3) meltDegree[x][y] = true;
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (grid[x][y] == 0) continue;
                if (!meltDegree[x][y]) grid[x][y]--;
                total += grid[x][y];
            }
        }
        return total;
    }

    public static void dfs(int x, int y, int size) {
        iceSize++;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 > nx || nx >= size || 0 > ny || ny >= size || visited[nx][ny] || grid[nx][ny] == 0) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, size);
        }
    }
}