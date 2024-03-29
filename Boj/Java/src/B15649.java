import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B15649 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n];
        nums = new int[m];
        backTrack( 0);
        System.out.println(sb.toString());
    }
    static void backTrack(int length){
        if (length >= m){
            Arrays.stream(nums).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                visited[i] = true;
                nums[length] = i+1;
                backTrack(length+1);
                visited[i] = false;
            }
        }
    }
}
