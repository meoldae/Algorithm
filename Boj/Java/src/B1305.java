import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] neon = br.readLine().toCharArray();

        int[] p = new int[L];
        int j = 0;
        for (int i = 1; i < L; i++) {
            while(j > 0 && neon[i] != neon[j]) j = p[j - 1];

            if (neon[i] == neon[j]) p[i] = ++j;
            else p[i] = 0;
        }
        System.out.println(Arrays.toString(p));
        System.out.print(L - p[L-1]);
    }
}
