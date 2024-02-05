import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B10423 {
    static int[] p;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        p = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int[] cities = new int[N + 1];
        for (int i = 0; i < K; i++) {
            int plant = Integer.parseInt(st.nextToken());
            cities[plant] = 1;
        }

        PriorityQueue<int[]> cables = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cables.offer(new int[]{u, v, w});
        }

        int answer = 0;

        // cities[find(x)]가 0이면 합치고 1로 변경
        while (!cables.isEmpty()) {
            int[] cable = cables.poll();
            int city1 = cable[0];
            int city2 = cable[1];
            int cost = cable[2];

            // 이미 두 도시가 연결된 경우 무시
            if (isSameParent(city1, city2)) continue;

            // 두 도시가 서로 다른 발전소에 연결된 경우 무시
            if (cities[find(city1)] + cities[find(city2)] == 2) continue;

            // 두 도시 중 하나만 전기가 공급된 경우 연결하고 전기 공급
            if (cities[find(city1)] + cities[find(city2)] == 1) {
                cities[find(city1)] = 1;
                cities[find(city2)] = 1;
            }

            union(city1, city2);
            answer += cost;
        }
        System.out.print(answer);
    }

    public static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) p[y] = x;
        else p[x] = y;
    }

    public static boolean isSameParent(int x, int y){
        return p[x] == p[y];
    }
}
