import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2023 {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int start : new int[]{2, 3, 5, 7}){
            backTrack(start);
        }
        System.out.println(sb);
    }

    public static void backTrack(int num){
        if (String.valueOf(num).length() == n){
            sb.append(num).append("\n");
            return;
        }
        for (int i = 0; i < 10; i++){
            if (isPrime((num*10)+i)) backTrack((num*10)+i);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= (int) (Math.sqrt(num)) + 1; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
