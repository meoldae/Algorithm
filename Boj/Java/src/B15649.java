import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15649 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n];
        backTrack( 0);
    }
    static void backTrack(int length){
        if (length >= m){
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < n; i++){
            if (!visited[i]) {
                visited[i] = true;
                sb.append(i+1).append(" ");
                backTrack(length+1);
                sb.delete(sb.length()-2, sb.length());
                visited[i] = false;
            }
        }
    }
}
