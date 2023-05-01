import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> drinks = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) drinks.offer(Integer.parseInt(st.nextToken()));

        double answer = 0;
        while (drinks.size() > 1) {
            answer += drinks.poll() / 2.0;
        }
        answer += drinks.poll();

        System.out.printf("%.5f", answer);
    }
}
