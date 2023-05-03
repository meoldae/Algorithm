import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class B27377 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            long N = Long.parseLong(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger s = new BigInteger(st.nextToken());
            BigInteger t = new BigInteger(st.nextToken());

            BigInteger count = new BigInteger("0");
            while(N > 0){
                if ((N & 1) == 1) {
                    N -= 1L;
                    count = count.add(new BigInteger(String.valueOf(s)));
                } else {
                    N >>= 1;
                    BigInteger num1 = new BigInteger(String.valueOf(N));
                    if (num1.multiply(s).compareTo(t) < 0){
                        count = count.add(num1.multiply(s));
                    }else {
                        count = count.add(t);
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}