import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] trees = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trees[i][0] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trees[i][1] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees, (o1, o2) -> o1[1] - o2[1]);
        long answer = 0;
        for (int i = 0; i < n; i++) answer += trees[i][0] + (long) trees[i][1] * i;
        System.out.print(answer);
    }
}