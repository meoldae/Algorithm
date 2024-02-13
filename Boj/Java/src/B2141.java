import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long[][] town = new long[N][2];

        long total = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            town[i][0] = Integer.parseInt(st.nextToken());
            town[i][1] = Integer.parseInt(st.nextToken());
            total += town[i][1];
        }

        Arrays.sort(town, (o1, o2) -> (int) (o1[0] - o2[0]));

        if ((total & 1) == 1) total++;
        long postOffice = 0;
        for (long[] t : town) {
            postOffice += t[1];
            if (postOffice >= total / 2) {
                System.out.print(t[0]);
                break;
            }
        }
    }
}
