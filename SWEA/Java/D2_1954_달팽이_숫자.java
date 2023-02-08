import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_1954_달팽이_숫자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringBuilder sb = new StringBuilder();
            int l = Integer.parseInt(br.readLine());
            int[][] snail = new int[l][l];

            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};

            int value = 1;
            int x = 0;
            int y = 0;
            int d = 0;

            while (value <= (int) Math.pow(l, 2)) {
                snail[x][y] = value;

                int nx = x + dx[d];
                int ny = y + dy[d];

                if (0 <= nx && nx < l && 0 <= ny && ny < l && snail[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    d = (d + 1) % 4;
                    x += dx[d];
                    y += dy[d];
                }
                value += 1;
            }
            sb.append("#").append(tc).append("\n");
            for (int[] row : snail) {
                Arrays.stream(row).forEach(num -> sb.append(num).append(" "));
                sb.append("\n");
            }
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb);
        }
    }
}
