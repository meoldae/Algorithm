import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14890 {
    static int N, L, answer;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            isArriveX(i);
            isArriveY(i);
        }
        System.out.print(answer);
    }

    public static void isArriveX(int c) {
        int now = map[0][c];
        boolean flag = false;
        int count = 1;

        for (int i = 1; i < N; i++) {
            int value = now - map[i][c];
            if (Math.abs(value) >= 2) { // 높이 차이가 2 이상인 경우 불가
                return;
            } else if (value == -1) {   // 오르막 경사로
                if (flag || count < L) return;       // 이미 경사로 배치중이거나 이전 바닥면이 L 이하면 불가
                count = 1;
            } else if (value == 1) {    // 내리막 경사로
                if (flag) return;       // 이미 경사로 배치중이면 불가
                flag = true;            // 차이가 1이라면 경사로 배치
                count = 1;
                if (L == 1) { // L 이 1이라면
                    flag = false;
                    count = 0;
                }
            } else if (value == 0) {    // 이전과 같은 높이면 바닥면 증가
                count++;
                if (flag && count == L) { // 경사로 배치중이고 바닥면이 L 만큼이면
                    flag = false;
                    count = 0;
                }
            }
            now = map[i][c];
        }
        if (!flag) answer++;
    }

    public static void isArriveY(int r) {
        int now = map[r][0];
        boolean flag = false;
        int count = 1;

        for (int i = 1; i < N; i++) {
            int value = now - map[r][i];
            if (Math.abs(value) >= 2) { // 높이 차이가 2 이상인 경우 불가
                return;
            } else if (value == -1) {   // 오르막 경사로
                if (flag || count < L) return;       // 이미 경사로 배치중이거나 이전 바닥면이 L 이하면 불가
                count = 1;
            } else if (value == 1) {    // 내리막 경사로
                if (flag) return;       // 이미 경사로 배치중이면 불가
                flag = true;            // 차이가 1이라면 경사로 배치
                count = 1;
                if (L == 1) { // L 이 1이라면
                    flag = false;
                    count = 0;
                }
            } else if (value == 0) {    // 이전과 같은 높이면 바닥면 증가
                count++;
                if (flag && count == L) { // 경사로 배치중이고 바닥면이 L 만큼이면
                    flag = false;
                    count = 0;
                }
            }
            now = map[r][i];
        }
        if (!flag) answer++;

    }
}
