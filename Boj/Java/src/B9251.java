import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        int[][] lcs = new int[s1.length+1][s2.length+1];

        for (int i = 1; i <= s1.length; i++){
            for (int j = 1; j <= s2.length; j++){
                if (s1[i-1] == s2[j-1]){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        System.out.println(lcs[s1.length][s2.length]);
    }
}