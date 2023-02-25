import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15683 {
    static int answer = Integer.MAX_VALUE, N, M;
    static int[][] board, copyBoard;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<int[]> cctv = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        copyBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value != 0 && value != 6) cctv.add(new int[]{i, j});
                board[i][j] = value;
            }
        }
        monitor(board, 0);
        System.out.print(answer);
    }

    static void monitor(int[][] copiedBoard, int count) {
        if (count == cctv.size()) {
            answer = Math.min(answer, getBlindSpot(copiedBoard));
            return;
        }
        int[] now = cctv.get(count);
        int[][] newBoard;
        switch (board[now[0]][now[1]]) {
            case 1:
                for (int d = 0; d < 4; d++) {
                    newBoard = copy(copiedBoard);
                    setMonitoring(newBoard, now, d);
                    monitor(newBoard, count + 1);
                }
                break;
            case 2:
                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 0);
                setMonitoring(newBoard, now, 2);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 1);
                setMonitoring(newBoard, now, 3);
                monitor(newBoard, count + 1);
                break;
            case 3:
                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 0);
                setMonitoring(newBoard, now, 1);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 1);
                setMonitoring(newBoard, now, 2);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 2);
                setMonitoring(newBoard, now, 3);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 3);
                setMonitoring(newBoard, now, 0);
                monitor(newBoard, count + 1);
                break;
            case 4:
                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 0);
                setMonitoring(newBoard, now, 1);
                setMonitoring(newBoard, now, 2);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 1);
                setMonitoring(newBoard, now, 2);
                setMonitoring(newBoard, now, 3);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 2);
                setMonitoring(newBoard, now, 3);
                setMonitoring(newBoard, now, 0);
                monitor(newBoard, count + 1);

                newBoard = copy(copiedBoard);
                setMonitoring(newBoard, now, 3);
                setMonitoring(newBoard, now, 0);
                setMonitoring(newBoard, now, 1);
                monitor(newBoard, count + 1);
                break;
            case 5:
                newBoard = copy(copiedBoard);
                for (int d = 0; d < 4; d++) setMonitoring(newBoard, now, d);
                monitor(newBoard, count + 1);
                break;
        }
    }

    static int getBlindSpot(int[][] targetBoard) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (targetBoard[i][j] == 0) sum++;
            }
        }
        return sum;
    }

    static void setMonitoring(int[][] newBoard, int[] location, int d) {
        int x = location[0];
        int y = location[1];

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (0 > nx || nx >= N || 0 > ny || ny >= M || newBoard[nx][ny] == 6) break;
            if (newBoard[nx][ny] == 0) newBoard[nx][ny] = 9;

            x = nx;
            y = ny;
        }
    }

    static int[][] copy(int[][] newBoard) {
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                res[i][j] = newBoard[i][j];
            }
        }
        return res;
    }
}
