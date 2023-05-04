import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end});
        }

        int answer = 1;
        rooms.add(pq.poll()[1]);
        while(!pq.isEmpty()) {
            int[] meeting = pq.poll();
            if (!rooms.isEmpty() && rooms.peek() <= meeting[0]) {
                rooms.poll();
            }
            rooms.add(meeting[1]);
            answer = Math.max(answer, rooms.size());
        }
        System.out.print(answer);
    }
}
