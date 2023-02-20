import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int answer = 0;
        while (N > 0) {
            int square = (int) Math.pow(2, N-1);
            int value = square * square;
            if (r < square && c >= square) {
                c -= square;
                answer += value;
            } else if (r >= square && c < square) {
                r -= square;
                answer += value * 2;
            } else if (r >= square && c >= square){
                r -= square;
                c -= square;
                answer += value * 3;
            }
            N -= 1;
        }
        System.out.println(answer);
    }
}