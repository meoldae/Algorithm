import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class B15666 {
    static int n, m;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        backTrack(0, 0);
        set.stream().forEach(s -> System.out.println(s));
    }

    static void backTrack(int start, int idx){
        if (idx == m){
            set.add(sb.toString());
            return;
        }

        for (int i = start; i < n; i++){
            sb.append(nums[i]).append(" ");
            backTrack(i, idx+1);
            sb.delete(sb.length() - String.valueOf(nums[i]).length() - 1, sb.length());
        }
    }
}
