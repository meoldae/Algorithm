import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B12851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int count = Integer.MAX_VALUE;
        int answer = 0;
        int[] visited = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (visited[now] > count) continue;

            if (now == k) {
                if (visited[now] < count) {
                    count = visited[now];
                    answer = 1;
                } else if (visited[now] == count) {
                    answer++;
                }
            }
            if (now - 1 >= 0) {
                if (visited[now - 1] == 0 || visited[now - 1] == visited[now] + 1) {
                    queue.add(now - 1);
                    visited[now - 1] = visited[now] + 1;
                }
            }
            if (now * 2 <= 100001 && now != 0) {
                if (visited[now * 2] == 0 || visited[now * 2] == visited[now] + 1) {
                    queue.add(now * 2);
                    visited[now * 2] = visited[now] + 1;
                }
            }
            if (now + 1 <= k) {
                if (visited[now + 1] == 0 || visited[now + 1] == visited[now] + 1) {
                    queue.add(now + 1);
                    visited[now + 1] = visited[now] + 1;
                }
            }
        }
        System.out.println(count);
        System.out.println(answer);
    }
}
