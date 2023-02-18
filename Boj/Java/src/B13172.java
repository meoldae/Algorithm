import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13172 {
    static long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long s = Long.parseLong(st.nextToken());
            long g = gcd(n, s);
            n /= g;
            s /= g;
            answer += (s * modula(n, MOD - 2)) % MOD;
            answer %= MOD;
        }
        System.out.println(answer);
    }

    static long gcd(long x, long y) {
        long a = Math.max(x, y);
        long b = Math.min(x, y);
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    static long modula(long x, long y) {
        if (y == 1) return x;
        if (y % 2 != 0) {
            return x * modula(x, y-1) % MOD;
        }
        long divide = modula(x, y/2);
        return (divide * divide) % MOD;
    }
}
