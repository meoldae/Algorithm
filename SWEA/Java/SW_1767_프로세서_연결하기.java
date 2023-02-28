import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class SW_1767_프로세서_연결하기 {
    static int N;
    static int[][] board;
    static ArrayList<int[]> processors;
    static int[] answerList;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            processors = new ArrayList<>();
            answerList = new int[N];
            Arrays.fill(answerList, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (input[j].equals("1")) processors.add(new int[]{i, j});
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }
            backTrack(0, 0, 0);
            for (int i = N - 1; i >= 0; i--) {
                if (answerList[i] != Integer.MAX_VALUE) {
                    sb.append("#").append(tc).append(" ").append(answerList[i]).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    static void backTrack(int count, int exynos, int weighted) {
        if (count == N) {
            if (exynos > 0) answerList[exynos - 1] = Math.min(answerList[exynos - 1], weighted);
            return;
        }
        if (exynos > 0) answerList[exynos-1] = Math.min(answerList[exynos-1], weighted);

        for (int d = 0; d < 4; d++) {
            int connected = isPossible(processors.get(count), d);
            if (connected == 0) {
                backTrack(count + 1, exynos + 1, weighted);
                break;
            } else if (connected < 99){
                connectCable(processors.get(count), d, true);
                backTrack(count + 1, exynos + 1, weighted + connected);
                connectCable(processors.get(count), d, false);
            }
        }
        backTrack(count + 1, exynos, weighted);
    }

    static void connectCable(int[] processor, int d, boolean flag) {
        int x = processor[0];
        int y = processor[1];

        if (flag) {
            while(true){
                x += dx[d];
                y += dy[d];
                if (0 > x || x >= N || 0 > y || y >= N)  return;
                board[x][y] = 9;
            }
        } else {
            while(true){
                x += dx[d];
                y += dy[d];
                if (0 > x || x >= N || 0 > y || y >= N)  return;
                board[x][y] = 0;
            }
        }
    }

    static int isPossible(int[] processor, int d) {
        int x = processor[0];
        int y = processor[1];
        int length = 0;
        while (true) {
            x += dx[d];
            y += dy[d];
            if (0 > x || x >= N || 0 > y || y >= N) {
                return length;
            }
            if (board[x][y] == 1 || board[x][y] == 9) return 99;

            length++;
        }
    }
}
