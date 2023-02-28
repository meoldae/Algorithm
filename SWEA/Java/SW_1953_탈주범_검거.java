import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1953_탈주범_검거 {
    static int[][] direction = {{0, 1, 2, 3}, {0, 1}, {2, 3}, {0, 3}, {1, 3}, {1, 2}, {0, 2}};
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            board = new int[N][M];
            for (int i = 0; i < N; i++){
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

        }
    }
    static boolean isPossible(int x, int y, int d){
        int nextType = board[x+dx[d]][y+dy[d]];
        if (nextType == 0) return false;
        for (int next : direction[nextType]) {
           if ((d + 2) % 4 == next) return true;
        }
        return false;
    }
}
