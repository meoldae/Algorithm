import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class B2036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> pos = new PriorityQueue<>((o1, o2) -> o2 - o1);
        Queue<Integer> neg = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        long score = 0;
        while (!pos.isEmpty()) {
            int temp = pos.poll();
            if (temp > 1) {
                if (!pos.isEmpty()) {
                    if (pos.peek() == 1) score += temp;
                    else score += (long) temp * pos.poll();
                } else score += temp;
            } else score += temp;
        }

        while (!neg.isEmpty()) {
            int temp = neg.poll();
            if (!neg.isEmpty()) score += (long) temp * neg.poll();
            else score += temp;
        }
        System.out.print(score);
    }
}
