import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1421 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] trees = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, trees[i]);
        }

        long answer = 0;
        for (int l = 1; l <= max; l++) {
            long sum = 0;
            for (int tree : trees) {
                long count = 0;
                if (tree % l == 0) count = tree / l - 1;
                else count = tree / l;

                long cost = ((long) (tree / l) * W * l) - (C * count);

                if (cost > 0) sum += cost;
            }
            answer = Math.max(answer, sum);
        }
        System.out.print(answer);
    }
}
