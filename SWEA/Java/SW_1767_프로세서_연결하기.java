import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SW_1767_프로세서_연결하기 {
    static int connected, N;
    static int cable = Integer.MAX_VALUE;
    static int[][] board;
    static ArrayList<int[]> processors;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            processors = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (input[j].equals("1")) processors.add(new int[]{i, j});
                    board[i][j] = Integer.parseInt(input[j]);
                }
            }
            backTrack(0, 0);
            System.out.println(cable);
        }
    }

    static void backTrack(int count, int weighted) {
        if (count >= connected || count == processors.size()) {
            connected = count;
            cable = Math.min(cable, weighted);
        }
        for (int d = 0; d < 4; d++) {
            int tempCable = connectCable(processors.get(count), d, true);
            backTrack(count + 1, weighted + tempCable);
            connectCable(processors.get(count), d, false);
        }
    }

    static int connectCable(int[] processor, int d, boolean flag) {
        if (processor[0] == 0 || processor[0] == N - 1 || processor[1] == 0 || processor[1] == N - 1) {
            return 0;
        }
        int x = processor[0];
        int y = processor[1];
        if (flag) {
            int cable = 0;
            ArrayList<int[]> yes = new ArrayList<>();
            while (true) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 > nx || nx >= N || 0 > ny || ny >= N) {
                    for (int[] loca : yes) board[loca[0]][loca[1]] = 9;
                    return cable;
                }
                if (board[nx][ny] == 1) return 0;
                if (board[nx][ny] == 0) {
                    yes.add(new int[]{nx, ny});
                    cable++;
                    x = nx;
                    y = ny;
                }
            }
        } else {
            while (true) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (0 > nx || nx >= N || 0 > ny || ny >= N || board[nx][ny] == 1) return 0;
                if (board[nx][ny] == 9) {
                    board[nx][ny] = 0;
                    x = nx;
                    y = ny;
                }
            }
        }
    }
}
