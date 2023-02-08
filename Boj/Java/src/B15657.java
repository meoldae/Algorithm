import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15657 {
    static int n, m;
    static int[] nums;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        answer = new int[m];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        backTrack(0, 0);
        System.out.println(sb.toString());
    }

    static void backTrack(int start, int idx) {
        if (idx >= m) {
            for (int i = 0; i < m; i++) sb.append(answer[i]).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            answer[idx] = nums[i];
            backTrack(i, idx + 1);
        }
    }
}
