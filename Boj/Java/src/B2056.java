import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] degree = new int[N + 1];
        int[] costs = new int[N + 1];
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            costs[i + 1] = Integer.parseInt(st.nextToken());

            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                degree[i + 1]++;
                graph[Integer.parseInt(st.nextToken())].add(i + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] totalCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                totalCount[i] = costs[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]){
                totalCount[next] = Math.max(totalCount[next], totalCount[now] + costs[next]);
                if (--degree[next] == 0) queue.offer(next);
            }
        }
        System.out.print(Arrays.stream(totalCount).max().getAsInt());
    }
}