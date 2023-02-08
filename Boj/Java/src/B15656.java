import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15656 {
    static int n, m;
    static int[] nums;
    static int[] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[m];
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        permWithReplacement(0);
        System.out.println(sb.toString());
    }

    static void permWithReplacement(int count) throws IOException {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            answer[count] = nums[i];
            permWithReplacement(count + 1);
        }
    }
}
