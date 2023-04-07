import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {
    static long[] prefixSum, nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        prefixSum = new long[N + 1];
        nums = new long[N];
        for (int i = 1; i <= N; i++) {
            nums[i - 1] = Long.parseLong(br.readLine());
            update(i, nums[i - 1]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken());
            long dst = Long.parseLong(st.nextToken());

            if (command == 1) {
                update(src, dst - nums[src - 1]);
                nums[src - 1] = dst;
            }
            else if (command == 2) sb.append(partialSum(src, (int) dst)).append("\n");
        }
        System.out.print(sb);
    }

    static void update(int index, long diff) {
        while (index < prefixSum.length) {
            prefixSum[index] += diff;
            index += (index & -index);
        }
    }

    static long partialSum(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    static long sum(int index) {
        long result = 0L;
        while (index > 0) {
            result += prefixSum[index];
            index -= (index & -index);
        }
        return result;
    }
}