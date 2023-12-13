import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B13913 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
            return;
        }

        Map<Integer, Integer> history = new HashMap<>();
        int[] count = new int[200002];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(n);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (0 >
                    now || now > 100000) {
                continue;
            }

            if (now == k) {
                System.out.println(count[now]);
                while(true) {
                    sb.insert(0, now+" ");
                    if (now == n) {
                        System.out.print(sb);
                        return;
                    }
                    now = history.get(now);
                }
            }

            int n1 = now + 1;
            if (count[n1] == 0 || count[n1] > count[now] + 1) {
                history.put(n1, now);
                queue.offer(n1);
                count[n1] = count[now] + 1;
            }

            int n2 = now - 1;
            if (n2 >= 0) {
                if (count[n2] == 0 || count[n2] > count[now] + 1) {
                    history.put(n2, now);
                    queue.offer(n2);
                    count[n2] = count[now] + 1;
                }
            }

            int n3 = now * 2;
            if (count[n3] == 0 || count[n3] > count[now] + 1) {
                history.put(n3, now);
                queue.offer(n3);
                count[n3] = count[now] + 1;
            }
        }
    }
}