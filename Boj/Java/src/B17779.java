import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17779 {
    static int[][] board;
    static int N, peopleSum;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                peopleSum += board[i][j];
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N || y - d1 < 0 || y + d2 >= N) continue;
                        getDistrict(x, y, d1, d2);
                    }
                }
            }
        }
        System.out.print(answer);
    }

    public static void getDistrict(int x, int y, int d1, int d2) {
        int[] districts = new int[5];

        int point = 0;
        for (int i = 0; i < x + d1; i++) {
            if (i >= x) point++;
            for (int j = 0; j <= y - point; j++) districts[0] += board[i][j];
        }

        point = 0;
        for (int i = 0; i <= x + d2; i++) {
            if (i > x) point++;
            for (int j = y + 1 + point; j < N; j++) districts[1] += board[i][j];
        }

        point = 0;
        for (int i = x + d1; i < N; i++) {
            if (i <= x + d1 + d2) point++;
            for (int j = 0; j < y - d1 - 1 + point; j++) districts[2] += board[i][j];
        }

        point = 0;
        for (int i = x + d2 + 1; i < N; i++) {
            if (i <= x + d1 + d2 + 1) point++;
            for (int j = y + d2 + 1 - point; j < N; j++) districts[3] += board[i][j];
        }

        districts[4] = peopleSum - (districts[0] + districts[1] + districts[2] + districts[3]);
        Arrays.sort(districts);

        answer = Math.min(answer, districts[4] - districts[0]);
    }
}

// 1 2 3 7 8 9 2 3 = 35
// 4 1 6 1 4 2 1 1 3 9 4 = 36
// 6 9 1 1 1 = 18
// 1 9 5 1 9 9 = 34
// 4 6 6 6 9 = 31