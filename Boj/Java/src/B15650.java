import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B15650 {
    static int n, m;
    static boolean[] visited;
    static int[] nums;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        nums = new int[m];
        perm(0, 0);
        System.out.println(sb.toString());

    }
    static void perm(int start, int count){
        if (count >= m){
            Arrays.stream(nums).forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
            return;
        }
        for (int i = start; i < n; i++){
            if (!visited[i]) {
                visited[i] = true;
                nums[count] = i+1;
                perm(i+1, count+1);
                visited[i] = false;
            }
        }
    }
}
