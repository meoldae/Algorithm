import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B16236 {
    static int[][] ocean;
    static int[] shark;
    static int N;
    static int sharkSize = 2, sharkStack = 2;
    static ArrayList<int[]> fishes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ocean = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (input[j].equals("9")) {
                    shark = new int[]{i, j};
                    ocean[i][j] = 0;
                }else {
                    ocean[i][j] = Integer.parseInt(input[j]);
                }
            }
        }
        int time = 0;
        while (true) {
            fishes = new ArrayList<>();
            bfs();
            if (fishes.size() == 0) {
                break;
            }
            fishes.sort((o1, o2) -> {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            });
            time += eat();
        }
        System.out.print(time);
    }

    static void bfs() {
        int distance = Integer.MAX_VALUE;
        int[][] visited = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{shark[0], shark[1], 0});
        visited[shark[0]][shark[1]] = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (0 < ocean[now[0]][now[1]] && ocean[now[0]][now[1]] < sharkSize){
                if (now[2] < distance) {
                    fishes.add(new int[]{now[0], now[1], now[2]});
                    distance = now[2];
                }else if (now[2] == distance) fishes.add(new int[]{now[0], now[1], now[2]});
                else return; // 먼 거리는 볼 필요 없음
            }

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[nx][ny] == 0) {
                        if (ocean[nx][ny] <= sharkSize) {
                            visited[nx][ny] = 1;
                            queue.offer(new int[]{nx, ny, now[2] + 1});
                        }
                    }
                }
            }
        }
    }

    static int eat(){
        int[] fish = fishes.get(0);
        ocean[fish[0]][fish[1]] = 0;
        sharkStack--;
        if (sharkStack == 0){
            sharkSize++;
            sharkStack = sharkSize;
        }
        shark = new int[]{fish[0], fish[1]};
        return fish[2];
    }
}
