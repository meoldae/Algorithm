import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B23888 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            long l = Long.parseLong(st.nextToken());
            long r = Long.parseLong(st.nextToken());

            long n = r - l + 1;
            long first = a + (d * (l - 1));
            long last = a + (d * (r - 1));

            if (command == 1) sb.append(getSigma(n, first, last));
            else {
                if (l == r) sb.append(first);
                else sb.append(a > d ? getGCD(a, d) : getGCD(d, a));
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static long getSigma(long n, long l, long r) {
        return (n * (l + r)) / 2;
    }

    public static long getGCD(long a, long b) {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }
}