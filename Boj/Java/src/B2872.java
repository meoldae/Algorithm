import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2872 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] books = new int[N];
        for (int i = 0; i < N; i++) {
            books[i] = Integer.parseInt(br.readLine());
        }

        int bookNumber = N;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (books[N - i] == bookNumber) {
                cnt++;
                bookNumber--;
            }
        }
        System.out.println(N - cnt);
    }
}