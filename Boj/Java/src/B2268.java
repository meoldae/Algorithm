import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2268 {
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        tree = new long[N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            if (command == 0) {
                sb.append(getPartialSum(Math.min(src, dst), Math.max(src, dst))).append("\n");
            }else {
                update(src, dst - nums[src - 1]);
                nums[src - 1] = dst;
            }
        }
        System.out.print(sb);
    }

    static void update(int index, long value) {
        while(index < tree.length) {
            tree[index] += value;
            index += (index & -index);
        }
    }

    static long getPartialSum(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    static long sum(int index) {
        long result = 0L;
        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
}
