import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Segment Tree...
public class S2042 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] nums = new long[n];
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(br.readLine());
            sums[i+1] = nums[i] + sums[i];
        }
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int idx = Integer.parseInt(st.nextToken()) - 1;
                long diff = Long.parseLong(st.nextToken()) - nums[idx];
                for (int j = idx; j < n; j++) {
                    sums[j+1] += diff;
                }
            }
            if (command == 2) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                sb.append(sums[end] - sums[start-1]).append("\n");
            }
        }
        System.out.println(sb);
    }
}