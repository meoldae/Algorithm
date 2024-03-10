import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] top = new int[N][M];
        int[][] answer = new int[N][M];
        int[] front = new int[M];
        int[] side = new int[N];
        boolean flag = true;
        int frontMax = 0;
        int sideMax = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                top[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            front[i] = Integer.parseInt(st.nextToken());
            frontMax = Math.max(frontMax, front[i]);
            int sum = 0;
            for (int j = 0; j < N; j++) sum += top[j][i];
            if ((sum > 0 && front[i] == 0) || (sum == 0 && front[i] > 0)) flag = false;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--) {
            side[i] = Integer.parseInt(st.nextToken());
            sideMax = Math.max(sideMax, side[i]);
            int sum = 0;
            for (int j = 0; j < M; j++) sum += top[i][j];
            if ((sum > 0 && side[i] == 0) || (sum == 0 && side[i] > 0)) flag = false;
        }

        if (frontMax != sideMax) flag = false;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int block = 0;
                if (top[i][j] != 0) block = Math.min(front[j], side[i]);
                answer[i][j] = block;
                sb.append(block).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 0; i < N; i++) {
            int answerSide = 0;
            for (int j = 0; j < M; j++) answerSide = Math.max(answer[i][j], answerSide);
            if (side[i] != answerSide) flag = false;
        }

        for (int i = 0; i < M; i++) {
            int answerFront = 0;
            for (int j = 0; j < N; j++) answerFront = Math.max(answer[j][i], answerFront);
            if (front[i] != answerFront) flag = false;
        }

        System.out.print(flag ? sb : -1);
    }
}