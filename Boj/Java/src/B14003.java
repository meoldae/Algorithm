import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class B14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lis = new int[N + 1];
        int[] lisIdx = new int[N + 1];
        Arrays.fill(lis, Integer.MIN_VALUE);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (lis[count] < numbers[i]) {
                lis[++count] = numbers[i];
                lisIdx[i] = count;
            } else {
                int idx = binarySearch(lis, 0, count, numbers[i]);
                lis[idx] = numbers[i];
                lisIdx[i] = idx;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        Stack<Integer> stack = new Stack<>();
        for (int i = N; i >= 0; i--){
            if (lisIdx[i] == count) {
                stack.push(numbers[i]);
                count--;
            }
        }
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        System.out.println(sb);
    }

    static int binarySearch(int[] lis, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
