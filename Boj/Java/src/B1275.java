import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1275 {
    static long[] fenwick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        fenwick = new long[N + 1];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            update(i + 1, nums[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(getPartialSum(Math.min(x, y), Math.max(x, y))).append("\n");
            update(a, (long) b - (long) nums[a - 1]);
            nums[a - 1] = b;
        }
        System.out.print(sb);
    }

    static void update(int index, long value) {
        while (index < fenwick.length) {
            fenwick[index] += value;
            index += (index & -index);
        }
    }

    static long sum(int index) {
        long result = 0L;
        while (index > 0) {
            result += fenwick[index];
            index -= (index & -index);
        }
        return result;
    }

    static long getPartialSum(int start, int end) {
        return sum(end) - sum(start - 1);
    }
}
