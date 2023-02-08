import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15652 {
    static int n, m;
    static StringBuilder sb;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[m];
        sb = new StringBuilder();

        backTrack(0, 0);
        System.out.println(sb.toString());
    }
    static void backTrack(int start, int idx) {
        if (idx >= m){
            Arrays.stream(nums).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++){
            nums[idx] = i+1;
            backTrack(i, idx+1);
        }
    }
}
