import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {
    static int N;
    static int[] nums;
    // 덧셈, 뺄셈, 곱셈, 나눗셈
    static int[] operands = new int[4];
    static int MAX_VALUE = Integer.MIN_VALUE;
    static int MIN_VALUE = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operands[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(nums[0], 1);
        StringBuilder sb = new StringBuilder();
        sb.append(MAX_VALUE).append("\n").append(MIN_VALUE);
        System.out.print(sb);
    }

    static void backtracking(int num, int idx) {
        if (idx == N) {
            MIN_VALUE = Math.min(MIN_VALUE, num);
            MAX_VALUE = Math.max(MAX_VALUE, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operands[i] > 0) {
                int temp = num;
                if (i == 0) {
                    temp += nums[idx];
                } else if (i == 1) {
                    temp -= nums[idx];
                } else if (i == 2) {
                    temp *= nums[idx];
                } else if (i == 3) {
                    temp /= nums[idx];
                }
                operands[i]--;
                backtracking(temp, idx + 1);
                operands[i]++;
            }
        }
    }
}
