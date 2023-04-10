import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16978 {
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        tree = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            update(i + 1, nums[i]);
        }

        int M = Integer.parseInt(br.readLine());
        Queue<int[]> query = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 1) {
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                query.offer(new int[]{index, value});
            } else if (command == 2) {
                int k = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                pq.offer(new int[]{k, start, end, i});
            }
        }
        PriorityQueue<long[]> result = new PriorityQueue<>((o1, o2) -> (int) (o1[0] - o2[0]));

        int count = 0;
        while (!pq.isEmpty()) {
            if (count < pq.peek()[0]) {
                int[] q = query.poll();
                update(q[0], q[1] - nums[q[0] - 1]);
                nums[q[0] - 1] = q[1];
                count++;
                continue;
            }
            int[] now = pq.poll();
            result.offer(new long[]{now[3], getPartialSum(now[1], now[2])});
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) sb.append(result.poll()[1]).append("\n");
        System.out.print(sb);
    }

    static void update(int index, long value) {
        while (index < tree.length) {
            tree[index] += value;
            index += (index & -index);
        }
    }

    static long getPartialSum(int start, int end) {
        return getSum(end) - getSum(start - 1);
    }

    static long getSum(int index) {
        long result = 0L;
        while (index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
} 
