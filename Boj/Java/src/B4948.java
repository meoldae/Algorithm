import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class B4948 {
    static int[] primes = new int[246913];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i < 246912; i++) {
            if (isPrime(i)) {
                primes[i] = 1;
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (primes[i] == 1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i < ((int) Math.sqrt(num)) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}