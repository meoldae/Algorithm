import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B17090 {

    static int[][] flag;
    static char[][] board;
    static int N, M;
    static Map<Character, Integer> direction = new HashMap<Character, Integer>() {{ put('U', 0); put('R', 1); put('D', 2); put('L', 3); }};

    public static void main(String[] args) throws IOException {
        /*
        탐색 후 탈출 가능하면 Flag True 로 두기
        도달해서 True 면 그냥 탈출 가능하도록
        Visited / Flag 배열 두개 사용
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        flag = new int[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (check(i, j)) count++;
            }
        }
        System.out.print(count);
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || flag[x][y] == 1) return true;
        if (flag[x][y] == 2) return false;

        flag[x][y] = 2;

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int d = direction.get(board[x][y]);
        int nx = x + dx[d];
        int ny = y + dy[d];
        if (check(nx, ny)){
            flag[x][y] = 1;
            return true;
        }
        return false;
    }
}
