import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11444 {
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000007;
        long n = Long.parseLong(br.readLine());
        // 파사노 주기
        // Mod = 10^k 일 때, k > 2 이면 주기는 항상 15 * 10^k-1
        long p = (long) (15 * Math.pow(10, 5));
        fibo = new int[(int) p];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i < fibo.length; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % mod;
        }
        System.out.println(fibo[((int)(n%p))]);
    }
}

