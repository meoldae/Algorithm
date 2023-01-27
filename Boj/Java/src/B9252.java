import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9252 {
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

        char[] answer = new char[lcs[s1.length][s2.length]];
        int count = lcs[s1.length][s2.length];
        int i = s1.length;
        int j = s2.length;
        while (count > 0){
            if (lcs[i-1][j] == count){
                --i;
            }else if (lcs[i][j-1] == count){
                --j;
            }else {
                answer[count-1] = s1[i-1];
                count = lcs[--i][--j];
            }
        }

        System.out.println(lcs[s1.length][s2.length]);
        if (lcs[s1.length][s2.length] != 0){
            for(char c : answer){
                System.out.print(c);
            }
        }
    }
}