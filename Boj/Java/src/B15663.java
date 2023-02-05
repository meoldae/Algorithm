import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B15663 {
    static int n, m;
    static int[] nums;
    static int[] answer;
    static boolean[] visited;
    static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        nums = new int[n];
        answer = new int[m];
        visited = new boolean[n];
        input = br.readLine().split(" ");
        for (int i = 0; i < n; i ++){
            nums[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(nums);
        backTrack(0);
        set.stream().forEach(System.out::println);
    }
    static void backTrack(int idx){
        if (idx >= m) {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(answer).forEach(num -> sb.append(num).append(" "));
            set.add(sb.toString().trim());
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                answer[idx] = nums[i];
                backTrack(idx+1);
                visited[i] = false;
            }
        }
    }
}
