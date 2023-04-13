import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17265 {
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int N, maxAnswer, minAnswer;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        minAnswer = Integer.MAX_VALUE;
        maxAnswer = Integer.MIN_VALUE;
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = st.nextToken().charAt(0);
        }
        dfs(0, 0, 0, new char[9]);
        System.out.print(maxAnswer + " " + minAnswer);
    }

    static void dfs(int x, int y, int count, char[] input) {
        if (x == N - 1 && y == N - 1) {
            input[count] = board[x][y];
            int value = calc(input, count);
            maxAnswer = Math.max(maxAnswer, value);
            minAnswer = Math.min(minAnswer, value);
            return;
        }

        input[count] = board[x][y];

        for (int d = 0; d < 2; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= N || ny >= N) continue;
            dfs(nx, ny, count + 1, Arrays.copyOf(input, 9));
        }
    }

    static int calc(char[] s, int count) {
        int result = s[0] - '0';
        for (int i = 1; i < count; i += 2) {
            if ('+' == s[i]) result += s[i + 1] - '0';
            else if ('-' == s[i]) result -= s[i + 1] - '0';
            else if ('*' == s[i]) result *= s[i + 1] - '0';
        }
        return result;
    }
}
