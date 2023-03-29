import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] entrance = new long[(int) N];

        long left = Long.MAX_VALUE;
        long right = 0L;

        for (int i = 0; i < N; i++) {
            entrance[i] = Long.parseLong(br.readLine());
            left = Math.min(left, entrance[i]);
            right = Math.max(right, entrance[i]);
        }

        right *= M;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0L;

            for (Long judge : entrance) {
                count += (mid / judge);
                if (count >= M) break;
            }

            if (count >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(left);
    }
}
