import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < 3; i++) {
            a += x[i] * y[(i + 1) % 3];
            b += y[i] * x[(i + 1) % 3];
        }

        if (a - b > 0) System.out.println(1);
        else if (a == b) System.out.println(0);
        else System.out.println(-1);
    }
}
