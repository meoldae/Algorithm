import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1368 {
    static int[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        p = new int[N + 1];
        for (int i = 0; i < N + 1; i++) p[i] = i;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(br.readLine());
            pq.offer(new int[]{0, i + 1, cost});
        }

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = i + 1; j < N; j++) pq.offer(new int[]{i + 1, j + 1, Integer.parseInt(input[j])});
        }

        int paddy = 0;
        int answer = 0;
        while (paddy <= N && !pq.isEmpty()) {
            int[] now = pq.poll();
            if (isSameParent(now[0], now[1])) continue;
            union(now[0], now[1]);
            answer += now[2];
            paddy++;
        }
        System.out.print(answer);
    }

    // Union Find
    static int find(int x) {
        if (x == p[x]) return x;
        return p[x] = find(p[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (!isSameParent(x, y)) {
            if (x <= y) p[y] = x;
            else p[x] = y;
        }
    }

    static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}
