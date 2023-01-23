import java.io.*;

public class B15651 {
    static int[] answer;
    static int m, n;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        answer = new int[n];
        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int l) throws IOException {
        if (l == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            bw.write(sb+"\n");
        } else {
            for (int i = 1; i <= n; i++) {
                answer[l] = i;
                dfs(l + 1);
            }
        }
    }
}
