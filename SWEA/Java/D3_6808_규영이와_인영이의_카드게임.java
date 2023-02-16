import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class D3_6808_규영이와_인영이의_카드게임 {
    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= N; tc++) {
            win = 0;
            lose = 0;
            boolean[] visited = new boolean[19];
            int[] kyuyeong = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.stream(kyuyeong).forEach(num -> visited[num] = true);
            int[] inyeong = IntStream.range(1, 19).filter(num -> !visited[num]).toArray();

            Arrays.sort(inyeong);

            do {
                fight(kyuyeong, inyeong);
            } while (nextPerm(inyeong));
            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean nextPerm(int[] in) {
        int i = 8;
        while (i > 0 && in[i - 1] >= in[i]) --i;

        if (i == 0) return false;

        int j = 8;
        while (in[i - 1] >= in[j]) --j;

        swap(in, i - 1, j);

        int k = 8;
        while (i < k) {
            swap(in, i++, k--);
        }
        return true;
    }

    private static void swap(int[] in, int x, int y) {
        int temp = in[x];
        in[x] = in[y];
        in[y] = temp;
    }

    static void fight(int[] k, int[] i) {
        int kScore = 0;
        int iScore = 0;
        for (int idx = 0; idx < 9; idx++) {
            if (k[idx] > i[idx]) kScore += k[idx] + i[idx];
            else iScore += k[idx] + i[idx];
        }
        if (kScore > iScore) win++;
        else lose++;
    }
}
