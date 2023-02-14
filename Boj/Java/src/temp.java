import java.io.*;
import java.util.*;

public class temp {
    static List<int[]> home = new LinkedList<>();
    static List<int[]> chicken = new LinkedList<>();
    static int[] chickenSelec;
    static int min = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                String str = st.nextToken();
                if (str.equals("2")) { // 치킨집들 저장
                    chicken.add(new int[] { i, j });
                } else if (str.equals("1")) { // 사람 사는 곳 저장
                    home.add(new int[] { i, j });
                }
            }

        }

        chickenSelec = new int[M];
        nCr(0, 0);
        System.out.println(min);
    }

    // 치킨집 끼리는 조합, 사람들 끼리는 브루트 포스
    static void nCr(int cnt, int start) {
        if (cnt == M) {
            int distance = 0;
            for (int i = 0; i < M; ++i) {
                int temp = Integer.MAX_VALUE;// 치킨집 ~ 집 별 치킨 거리
                for (int[] h : home) {
                    int[] store = chicken.get(chickenSelec[i]);
                    temp = Math.min(temp, Math.abs(store[0] - h[0])
                            + Math.abs(store[1] - h[1]));
                }
                distance += temp;
            }
            min = Math.min(min, distance);
            return;
        }

        for (int i = start; i < chicken.size(); ++i) {
            chickenSelec[cnt] = i;
            nCr(cnt + 1, i + 1);
        }
    }
}