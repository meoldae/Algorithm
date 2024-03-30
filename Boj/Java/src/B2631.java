import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2631 {
    static int[] kids;
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        kids = new int[N];
        for (int i = 0; i < N; i++) {
            kids[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (dp[count] < kids[i]) {
                dp[++count] = kids[i];
            } else {
                int idx = binarySearch(count, kids[i]);
                dp[idx] = kids[i];
            }
        }
        System.out.print(N - count);
    }

    static int binarySearch(int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
