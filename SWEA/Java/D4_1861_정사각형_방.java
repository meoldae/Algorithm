import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D4_1861_정사각형_방 {
    static int[][] board, visited;
    static int[] dp;
    static int n;

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        int t = Integer.parseInt(br.readLine());
//        for (int tc = 1; tc <= t; tc++) {
//            n = Integer.parseInt(br.readLine());
//            board = new int[n][n];
//            dp = new int[n * n + 1];
//            for (int i = 0; i < n; i++) {
//                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            }
//            search();
//            int count = 1;
//            int value = 1;
//            int location = Integer.MAX_VALUE;
//
//            for (int i = n * n; i > 0; i--) {
//                if (dp[i] == 0) {
//                    count = 1;
//                } else {
//                    ++count;
//                    if (value <= count) {
//                        value = count;
//                        location = Math.min(location, i);
//                    }
//                }
//            }
//            sb.append("#").append(tc).append(" ").append(location).append(" ").append(value).append("\n");
//        }
//        System.out.println(sb);
//    }
//
//    static void search() {
//        int[] dx = {0, 0, 1, -1};
//        int[] dy = {1, -1, 0, 0};
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (int d = 0; d < 4; d++) {
//                    int nx = i + dx[d];
//                    int ny = j + dy[d];
//                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
//                        if (board[i][j] + 1 == board[nx][ny]) {
//                            dp[board[i][j]]++;
//                        }
//                    }
//                }
//            }
//        }
//    }
    // PQ 이용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            visited = new int[n][n];
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)-> o1[2] - o2[2]);
            for (int i = 0; i < n; i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int j = 0; j < n; j++){
                    pq.offer(new int[]{i, j, board[i][j], 1});
                }
            }
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};

            int maxVal = 0;
            int location = Integer.MAX_VALUE;
            while (!pq.isEmpty()){
                int[] now = pq.poll();

                for (int d = 0; d < 4; d++){
                    int nx = now[0] + dx[d];
                    int ny = now[1] + dy[d];

                    if (0 <= nx && nx < n && 0 <= ny && ny < n){
                        if (visited[nx][ny] == 1) continue;
                        if (board[now[0]][now[1]] + 1 == board[nx][ny]){
                            visited[nx][ny] = 1;
                            pq.offer(new int[]{nx, ny, now[2], now[3] + 1});
                            if (maxVal <= now[3]+1){
                                location = Math.min(location, now[2]);
                                maxVal = now[3]+1;
                            }
                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(location).append(" ").append(maxVal).append("\n");
        }
        System.out.println(sb);
    }
}


