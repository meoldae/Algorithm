import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10836 {
    static int[][] honeycomb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        honeycomb = new int[M][M];
        int[] growth = new int[(2 * M) - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            int weight = 0;
            while (idx < growth.length) {
                int count = Integer.parseInt(st.nextToken());
                while (count-- > 0) growth[idx++] += weight;
                weight++;
            }
        }

        int idx = 0;
        int x = M - 1;
        int y = 0;

        while (y < M) {
            honeycomb[x][y] = growth[idx++];
            if (x != 0) x--;
            else y++;
        }

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                if (r == 0 || c == 0) sb.append(honeycomb[r][c] + 1).append(" ");
                else sb.append(honeycomb[0][c] + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
