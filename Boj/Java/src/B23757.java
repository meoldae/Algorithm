import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B23757 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        int answerCount = 0;
        input = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            int hopeCount = Integer.parseInt(input[i]);
            if (pq.peek() >= hopeCount) {
                pq.add(pq.poll() - hopeCount);
                answerCount++;
            }
        }
        System.out.println(answerCount == M ? 1 : 0);
    }
}
