import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] staff = new int[N];
        long right = 1000001;
        for (int i = 0; i < N; i++) {
            staff[i] = Integer.parseInt(st.nextToken());
            right = Math.min(right, staff[i]);
        }
        right *= M;
        long left = 0;
        while (left <= right) {
            long mid = (left + right) / 2;

            long balloon = 0;
            for (int s : staff) {
                balloon += mid / s;
            }

            if (balloon >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.print(left);
    }
}
