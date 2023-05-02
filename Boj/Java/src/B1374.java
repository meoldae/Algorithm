import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> lectures = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] lecture = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            lectures.offer(lecture);
        }

        int answer = 0;
        while(!lectures.isEmpty()) {
            int[] lecture = lectures.poll();
            while(!rooms.isEmpty() && rooms.peek() <= lecture[1]) {
                rooms.poll();
            }
            rooms.offer(lecture[2]);
            answer = Math.max(answer, rooms.size());
        }
        System.out.print(answer);
    }
}
