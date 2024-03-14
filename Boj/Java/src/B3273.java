import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(numbers);

        int x = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N - 1;
        int answer = 0;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == x) answer++;
            if (sum >= x) right--;
            else left++;
        }
        System.out.print(answer);

    }
}
