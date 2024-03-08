import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B17503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] beers = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beers[i][0] = v;
            beers[i][1] = c;
        }

        Arrays.sort(beers, (o1, o2) -> {
            if (o1[1] == o2[1]) return o2[0] - o1[0];
            else return o1[1] - o2[1];
        });

        Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        });

        int sum = 0;
        int level = 0;
        boolean flag = false;
        for (int[] beer : beers) {
            sum += beer[0];
            level = Math.max(level, beer[1]);
            pq.offer(beer);
            if (pq.size() == N) {
                if (sum >= M) {
                    flag = true;
                    break;
                }
                else {
                    int[] temp = pq.poll();
                    sum -= temp[0];
                }
            }
        }
        System.out.print(flag ? level : -1);
    }
}