import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B23843 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] devices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) devices[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(devices);

        if (M >= N) {
            System.out.println(devices[devices.length - 1]);
            return;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = N - 1; i >= 0; i--) {
            if (pq.size() < M) {
                pq.add(devices[i]);
            }else {
                pq.add(devices[i] + pq.poll());
            }
        }
        int answer = 0;
        while(!pq.isEmpty()) {
            answer = Math.max(answer, pq.poll());
        }
        System.out.print(answer);
    }
}
