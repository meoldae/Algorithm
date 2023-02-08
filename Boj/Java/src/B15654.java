import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15654 {
    static int n, m;
    static int[] nums;
    static int[] answer;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        answer = new int[m];
        visited = new boolean[n];
        permWithReplace(0);
        System.out.println(sb.toString());
    }
    static void permWithReplace(int count){
        if (count >= m){
            Arrays.stream(answer).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                visited[i] = true;
                answer[count] = nums[i];
                permWithReplace(count+1);
                visited[i] = false;
            }

        }
    }
}
