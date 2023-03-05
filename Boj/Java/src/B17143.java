import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class B17143 {
    static int R, C, answer;
    static Shark[][] sharks;

    static class Shark {
        int s, d, z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sharks = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            sharks[x][y] = new Shark(s, d, z);
        }

        answer = 0;
        for (int i = 1; i <= C; i++) {
            fishing(i);
            moving();
        }
        System.out.print(answer);
    }

    /**
     * X 좌표가 가장 0에 가깝고, Y 좌표가 일치하면 잡는다.
     * 입력 : column (열 정보)
     */
    private static void fishing(int col) {
        for (int i = 1; i <= R; i++) {
            if (sharks[i][col] != null) {
                answer += sharks[i][col].z;
                sharks[i][col] = null;
                return;
            }
        }
    }

    /**
     * 낚시 후에 상어가 이동한다.
     */
    private static void moving() {
        Shark[][] newSharks = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (sharks[i][j] != null) {
                    swim(i, j, sharks[i][j].s, sharks[i][j], newSharks);
                }
            }
        }
        sharks = newSharks;
    }

    /**
     * 상어 각각의 이동
     * 새로운 상어 배열에 이미 있으면 크기 비교해서 덮어 쓰고, 없으면 넣는다!
     */
    static void swim(int x, int y, int s, Shark shark, Shark[][] newSharks) {
        if (shark.d == 1) {
            if (x - s < 1) {
                s -= (x - 1);
                x = 1;
                shark.d = 2;
                swim(x, y, s, shark, newSharks);
            } else {
                x -= s;
                if (newSharks[x][y] == null) newSharks[x][y] = shark;
                else {
                    newSharks[x][y] = (newSharks[x][y].z > shark.z) ? newSharks[x][y] : shark;
                }
            }
        } else if (shark.d == 3) {
            if (C < y + s) {
                s -= (C - y);
                y = C;
                shark.d = 4;
                swim(x, y, s, shark, newSharks);
            } else {
                y += s;
                if (newSharks[x][y] == null) newSharks[x][y] = shark;
                else {
                    newSharks[x][y] = (newSharks[x][y].z > shark.z) ? newSharks[x][y] : shark;
                }
            }
        } else if (shark.d == 2) {
            if (R < x + s) {
                s -= (R - x);
                x = R;
                shark.d = 1;
                swim(x, y, s, shark, newSharks);
            } else {
                x += s;
                if (newSharks[x][y] == null) newSharks[x][y] = shark;
                else {
                    newSharks[x][y] = (newSharks[x][y].z > shark.z) ? newSharks[x][y] : shark;
                }
            }
        } else {
            if (y - s < 1) {
                s -= (y - 1);
                y = 1;
                shark.d = 3;
                swim(x, y, s, shark, newSharks);
            } else {
                y -= s;
                if (newSharks[x][y] == null) newSharks[x][y] = shark;
                else {
                    newSharks[x][y] = (newSharks[x][y].z > shark.z) ? newSharks[x][y] : shark;
                }
            }
        }
    }
}
