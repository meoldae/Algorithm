import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B30974 {

    public static boolean[] primes = new boolean[10000001];
    public static int[] disasterCode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        disasterCode = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) disasterCode[i] = Integer.parseInt(st.nextToken());

        List<int[]>[] roads = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) roads[i] = new ArrayList<>();

        calcPrimeNumbers();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            int sumOfCodes = disasterCode[start] + disasterCode[end];
            if (primes[sumOfCodes]) continue;

            roads[start].add(new int[]{end, cost});
            roads[end].add(new int[]{start, cost});
        }


        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        pq.offer(new long[]{1, 0});

        while(!pq.isEmpty()) {
            long[] now = pq.poll();

            if(distance[(int) now[0]] < now[1]) continue;

            for (int[] next : roads[(int) now[0]]) {
                
                if (now[1] + next[1] < distance[next[0]]) {
                    distance[next[0]] = now[1] + next[1];
                    pq.offer(new long[]{next[0], now[1] + next[1]});
                }
            }
        }
        System.out.print(distance[N] == Long.MAX_VALUE ? "Now where are you?" : distance[N]);
    }

    public static void calcPrimeNumbers(){
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (primes[i]) continue;

            for (int j = i * i; j <= 10000000; j += i) {
                primes[j] = true;
            }
        }
    }
}
