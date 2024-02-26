import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aNumerator = Integer.parseInt(st.nextToken());
        int aDenominator = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bNumerator = Integer.parseInt(st.nextToken());
        int bDenominator = Integer.parseInt(st.nextToken());

        int numerator = (aNumerator * bDenominator) + (bNumerator * aDenominator);
        int denominator = aDenominator * bDenominator;

        StringBuilder sb = new StringBuilder();
        int gcd = gcd(numerator, denominator);

        sb.append(numerator / gcd).append(" ").append(denominator / gcd);
        System.out.print(sb);
    }
    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
