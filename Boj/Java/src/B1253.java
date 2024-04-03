import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] numbers = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numbers[i] = Long.parseLong(st.nextToken());
        Arrays.sort(numbers);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (isGood(numbers, numbers[i], i)) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static boolean isGood(long[] numbers, long target, int i) {
        int left = i == 0 ? 1 : 0;
        int right = i == numbers.length - 1 ? numbers.length - 2 : numbers.length - 1;
        while (left < right) {
            long sum = numbers[left] + numbers[right];

            if (sum > target) {
                if (--right == i) right--;
            }
            else if (sum < target) {
                if (++left == i) left++;
            }
            else return true;
        }
        return false;
    }
}
