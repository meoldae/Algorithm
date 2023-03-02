import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B17472_2 {
    static int N, M, islandNo;
    static int[][] board;
    static PriorityQueue<int[]> pq;
    static int[] p;
    static ArrayList<int[]>[] islandHorizontal, islandVertical;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        islandHorizontal = new ArrayList[N];
        islandVertical = new ArrayList[M];
        pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < N; i++) islandHorizontal[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) islandVertical[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int island = Integer.parseInt(st.nextToken());
                if (island == 0) continue;
                islandHorizontal[i].add(new int[]{j, islandNo});
                islandVertical[j].add(new int[]{i, islandNo});
                islandNo++;
            }
        }

        for (int i = 0; i < N; i++) islandHorizontal[i].sort((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < M; i++) islandVertical[i].sort((o1, o2) -> o1[0] - o2[0]);

        bridgeCheck();

        p = new int[islandNo];
        for (int i = 0; i < islandNo; i++) p[i] = i;

        makeMST();
    }

    static void bridgeCheck() {
        for (int i = 0; i < N; i++) {
            if (islandHorizontal[i].size() > 1) {
                int[] now = islandHorizontal[i].get(0);
                for (int j = 1; j < islandHorizontal[i].size(); j++) {
                    int[] next = islandHorizontal[i].get(j);
                    if (next[0] - now[0] != 2) {
                        pq.offer(new int[]{now[1], next[1], next[0] - now[0] - 1});
                    }
                    now[0] = next[0];
                    now[1] = next[1];
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (islandVertical[i].size() > 1) {
                int[] now = islandVertical[i].get(0);
                for (int j = 1; j < islandVertical[i].size(); j++) {
                    int[] next = islandVertical[i].get(j);
                    if (next[0] - now[0] != 2) {
                        pq.offer(new int[]{now[1], next[1], next[0] - now[0] - 1});
                    }
                    now[0] = next[0];
                    now[1] = next[1];
                }
            }
        }
    }

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

    static void makeMST() {
        int answer = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (!isSameParent(now[0], now[1])) {
                union(now[0], now[1]);
                answer += now[2];
                count++;
            }
        }

        if (count == islandNo - 1) System.out.print(answer);
        else System.out.print(-1);
    }
}