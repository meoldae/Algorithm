import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10830 {
    // Divide & Conquer
    static int[][] A;
    static int n;
    static final int MOD = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int[] arr : dfs(b)){
            Arrays.stream(arr).forEach(num -> System.out.print((num%MOD)+" "));
            System.out.println();
        }
    }

    static int[][] dfs(long exp){
        if (exp > 1){
            int[][] ret = dfs(exp/2);
            if (exp % 2 == 0){
                return multiply(ret, ret);
            }
            return multiply(multiply(ret, ret), A);
        }
        return A;
    }
    static int[][] multiply(int[][] mat1, int[][] mat2){
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    ret[j][k] += mat1[j][i] * mat2[i][k];
                    ret[j][k] %= MOD;
                }
            }
        }
        return ret;
    }
}