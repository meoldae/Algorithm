import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B2210 {

    static Set<Integer> set;
    static int[][] board;
    static int[] nums;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();
        board = new int[5][5];
        nums = new int[6];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++) {
                nums[0] = board[i][j];
                dfs(i, j, 1);
            }
        }
        System.out.print(set.size());
    }

    static void dfs(int x, int y, int length) {
        if (length == 6) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(nums[i]);
            }
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 > nx || nx >= 5 || 0 > ny || ny >= 5) continue;

            nums[length] = board[nx][ny];
            dfs(nx, ny, length + 1);
        }
    }
}
