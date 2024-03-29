import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B14658 {
    static int N, M, L, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<int[]> stars = new ArrayList<>();
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            stars.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int answer = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int count = 0;
                int x = Math.min(stars.get(i)[0], stars.get(j)[0]);
                int y = Math.min(stars.get(i)[1], stars.get(j)[1]);

                for (int k = 0; k < K; k++) {
                    int[] star = stars.get(k);
                    if (x <= star[0] && y <= star[1] && star[0] <= x + L && star[1] <= y + L) count++;
                }
                answer = Math.max(answer, count);
            }
        }
        System.out.print(K - answer);
    }
}
