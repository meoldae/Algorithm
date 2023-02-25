import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B12738 {
    static int[] numbers, tempLis;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tempLis = new int[N];
        Arrays.fill(tempLis, Integer.MIN_VALUE);

        int right = 0;
        for (int i = 0; i < N; i++) {
            if (tempLis[right] < numbers[i]) {
                right++;
                if (right == N) {
                    System.out.print(right);
                    return;
                }
                tempLis[right] = numbers[i];
            } else {
                int idx = binarySearch(numbers[i], 0, right);
                tempLis[idx] = numbers[i];
            }
        }
        System.out.print(right);
    }

    static int binarySearch(int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (tempLis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
