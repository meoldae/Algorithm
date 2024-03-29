import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[100001];
        int answer = 0;
        int result = 0;
        int left = 0;
        int right = 0;
        while(right < N && left < N) {
            if (count[numbers[right]] < K) {
                count[numbers[right++]]++;
                result++;
            } else {
                --count[numbers[left++]];
                result--;
            }
            answer = Math.max(answer, result);
        }
        System.out.print(answer);
    }
}