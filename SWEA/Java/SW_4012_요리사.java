import java.io.*;
import java.util.Arrays;

public class SW_4012_요리사 {
    static int[][] ingredits;
    static int cnt;
    static int answer;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            answer = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            cnt = n / 2;
            ingredits = new int[n][];
            selected = new boolean[n];
            for (int i = 0; i < n; i++) {
                ingredits[i] = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
            comb(0, 0);
            bw.write("#"+tc+" "+answer+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void comb(int start, int count) {
        if (count == cnt) {
            int s1 = 0;
            int s2 = 0;
            for (int i = 0; i < selected.length - 1; i++) {
                for (int j = i; j < selected.length; j++) {
                    if (selected[i] && selected[j]) s1 += ingredits[i][j] + ingredits[j][i];
                    if (!selected[i] && !selected[j]) s2 += ingredits[i][j] + ingredits[j][i];
                }
            }
            answer = Math.min(answer, Math.abs(s1 - s2));
            return;
        }
        for (int i = start; i < ingredits.length; i++) {
            selected[i] = true;
            comb(i+1, count+1);
            selected[i] = false;
        }
    }
}