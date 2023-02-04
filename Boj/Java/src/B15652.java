import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15652 {
    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        sb = new StringBuilder();

        backTrack(0, 0);
    }
    static void backTrack(int start, int idx) {
        if (idx >= m){
            System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < n; i++){
            sb.append(i+1).append(" ");
            backTrack(i, idx+1);
            sb.delete(sb.length()-2, sb.length());
        }
    }
}
