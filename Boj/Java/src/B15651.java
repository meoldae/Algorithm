import java.io.*;

public class B15651 {
    static int[] answer;
    static int m, n;
    static BufferedWriter bw;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int l) throws IOException {
        if (l == m) {
            bw.write(sb.toString() + "\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            sb.append(i).append(" ");
            dfs(l + 1);
            sb.delete(sb.length()-2, sb.length());
        }
    }
}
