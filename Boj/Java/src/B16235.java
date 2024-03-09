import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16235 {
    static Queue<Integer>[][] land;
    static int[][] nutrient;
    static int[][] s2d2;
    static int[][] breed;
    static int N, M, K;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        nutrient = new int[N][N];
        s2d2 = new int[N][N];
        breed = new int[N][N];
        land = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                land[i][j] = new PriorityQueue<>();
                nutrient[i][j] = 5;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                s2d2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            land[x][y].offer(z);
            if (z >= 5 && z % 5 == 0) breed[x][y]++;
        }

        for (int i = 0; i < K; i++) {
            spring();
            fall();
            winter();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += land[i][j].size();
            }
        }
        System.out.print(answer);
    }

    public static void spring() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Queue<Integer> next = new PriorityQueue<>();
                int limit = land[i][j].size();
                boolean flag = true;
                for (int t = 0; t < limit; t++) {
                    int tree = land[i][j].poll();
                    if (tree > nutrient[i][j]) flag = false;

                    if (tree >= 5 && tree % 5 == 0) breed[i][j]--; // 성장하거나 죽거나 무조건 감소

                    if (flag) {
                        nutrient[i][j] -= tree++;
                        if (tree >= 5 && tree % 5 == 0) breed[i][j]++; // 자란 후 5의 배수면 증가
                        next.offer(tree);
                    } else {
                        nutrient[i][j] += tree / 2;
                    }
                }
                land[i][j] = next;
            }
        }
    }

    public static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 8; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (0 > nx || nx >= N || 0 > ny || ny >= N) continue;
                    for (int tree = 0; tree < breed[i][j]; tree++) {
                        land[nx][ny].offer(1);
                    }
                }
            }
        }
    }

    public static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nutrient[i][j] += s2d2[i][j];
            }
        }
    }
}
