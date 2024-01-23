import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] oven = new int[D + 1];
        oven[0] = 1000000001;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            oven[i] = Math.min(oven[i], oven[i - 1]);
        }

        int depth = D;
        st = new StringTokenizer(br.readLine());

        outer:
        for (int i = 0; i < N; i++) {
            int dough = Integer.parseInt(st.nextToken());
            for (int d = depth; d > 0; d--) {
                if (dough <= oven[d]) {
                    depth = d - 1;
                    continue outer;
                }
            }
            depth = 0;
        }
        System.out.print(depth);
    }
}
