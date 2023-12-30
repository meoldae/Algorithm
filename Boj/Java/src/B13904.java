import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]>[] tasks = new PriorityQueue[1001];
        for (int i = 0; i < 1001; i++) tasks[i] = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

        boolean[] visited = new boolean[N + 1];

        int due = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            due = Math.max(due, d);

            for (int j = d; j >= 1; j--) {
                tasks[j].add(new int[]{i, w});
            }
        }

        int answer = 0;
        while (due > 0) {
            int[] task = tasks[due].poll();

            if (task == null) {
                due--;
                continue;
            }

            if (visited[task[0]]) continue;

            else {
                visited[task[0]] = true;
                answer += task[1];
                due--;
            }
        }

        System.out.print(answer);
    }
}
