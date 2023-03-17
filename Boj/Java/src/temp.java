import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int[][] board;
    static int N, M, minTime, infection;
    static int[] selected;
    static List<int[]> cases;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        minTime = Integer.MAX_VALUE;

        // Virus 를 놓을 수 있는 위치
        List<int[]>viruses = new ArrayList<>();

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                int value = Integer.parseInt(st.nextToken());
                if (value == 2) viruses.add(new int[]{i, j});
                if (value == 0) infection++;
                board[i][j] = value;
            }
        }

        // 조합 : 바이러스를 놓을 수 있는 위치 중 M개 선택
        selected = new int[M];
        cases = new ArrayList<>();
        comb(0, 0, viruses.size());

        // BFS 탐색
        for (int[] situation : cases){
            bfs(situation, viruses);
        }

        System.out.print(minTime != Integer.MAX_VALUE ? minTime : -1);

    }
    static void comb(int start, int count, int size){
        if (count == M){
            cases.add(Arrays.copyOf(selected, selected.length));
            return;
        }
        for (int i = start; i < size; i++){
            selected[count] = i;
            comb(i+1, count+1, size);
        }
    }

    static void bfs(int[] situation, List<int[]> viruses) {
        int count = infection;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] visited = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();

        // 초기 바이러스 위치 추가 ( 선택된 바이러스 )
        for (int idx : situation){
            int[] virus = viruses.get(idx);
            visited[virus[0]][virus[1]] = 1;
            queue.offer(new int[]{virus[0], virus[1]});
        }
        int time = 0;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for (int d = 0; d < 4; d++){
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < N){
                    if (visited[nx][ny] == 0){
                        if (board[nx][ny] == 0 || board[nx][ny] == 2) {
                            visited[nx][ny] = visited[now[0]][now[1]] + 1;
                            queue.offer(new int[]{nx, ny});

                            if(--count < 0) break;
                        }
                        time = Math.min(time, visited[nx][ny]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (visited[i][j] == 0 && board[i][j] != 1) return;
            }
        }
        minTime = Math.min(minTime, Math.max(time - 1, 0));
    }
}