import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17144 {
    static int R, C, T;
    static int[][] air;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        air = new int[R][C];

        int[][] airConditioner = new int[2][];
        int count = 0;
        for (int i = 0; i < R; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                if (input[j].equals("-1")) airConditioner[count++] = new int[]{i, j};
                air[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (T > 0) {
            diffusion();
            airCirculationTop(airConditioner[0]);
            airCirculationBottom(airConditioner[1]);
            T--;
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                answer += Math.max(air[i][j], 0);
            }
        }
        System.out.print(answer);
    }

    static void diffusion() {
        int[][] after = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (air[i][j] == 0) continue;
                int dust = air[i][j] / 5;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (0 <= nx && nx < R && 0 <= ny && ny < C && air[nx][ny] != -1) {
                        after[nx][ny] += dust;
                        after[i][j] -= dust;
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                air[i][j] += after[i][j];
            }
        }
    }

    static void airCirculationTop(int[] airConditioner) {
        int x = airConditioner[0] - 1;
        int y = airConditioner[1];
        int d = 0;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || airConditioner[0] < nx || ny < 0 || C <= ny) {
                d++;
                continue;
            }
            if (air[nx][ny] == -1) {
                air[x][y] = 0;
                break;
            }

            air[x][y] = air[nx][ny];
            x = nx;
            y = ny;
        }
    }

    static void airCirculationBottom(int[] airConditioner) {
        int x = airConditioner[0] + 1;
        int y = airConditioner[1];
        int d = 2;

        while (true) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < airConditioner[0] || R <= nx || ny < 0 || C <= ny) {
                d = (d + 3) % 4;
                continue;
            }
            if (air[nx][ny] == -1) {
                air[x][y] = 0;
                break;
            }

            air[x][y] = air[nx][ny];
            x = nx;
            y = ny;
        }
    }
}
