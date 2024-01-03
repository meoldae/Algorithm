import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B25306 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = calXOR(a - 1) ^ calXOR(b);
        System.out.print(result);
    }

    public static long calXOR(long num) {
        if (num % 4 == 0) {
            return num;
        } else if (num % 4 == 1) {
            return 1;
        } else if (num % 4 == 2) {
            return num + 1;
        } else {
            return 0;
        }
    }
}
