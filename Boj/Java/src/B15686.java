import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {
    static int N, M;
    static ArrayList<int[]> houses;
    static ArrayList<int[]> chicken;
    static int[] select;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        houses = new ArrayList<>();
        chicken = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        select = new int[M];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                if (row[j].equals("1")) {
                    houses.add(new int[]{i + 1, j + 1});
                } else if (row[j].equals("2")) {
                    chicken.add(new int[]{i + 1, j + 1});
                }
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }

    static void comb(int start, int count) {
        if (count == M) {
            int cityDistance = 0;
            for (int[] h : houses) { // 집 반복
                int chickenDistance = Integer.MAX_VALUE;
                for (int i = 0; i < M; i++) { // 선택된 치킨집들
                    int[] c = chicken.get(select[i]);
                    chickenDistance = Math.min(chickenDistance, Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]));
                }
                cityDistance += chickenDistance;
            }
            answer = Math.min(answer, cityDistance);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            select[count] = i;
            comb(i + 1, count + 1);
        }
    }
}
