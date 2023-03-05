import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++){
            int sum = 0;
            for (int j = i; j < i + K; j++){
                sum += numbers[j];
            }
            answer = Math.max(answer, sum);
        }
        System.out.print(answer);
    }
}
