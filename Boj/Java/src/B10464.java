import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int result = s;

            for (int i = s + 1; i <= f; i++) {
                if (i % 4 == 0) break;
                result ^= i;
            }

            for (int i = f; i > s; i--) {
                if (i % 4 == 3) break;
                result ^= i;
            }

            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}
