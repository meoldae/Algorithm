import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11444 {
    final static long MOD = 1000000007;

    // 연립 방정식 이용...
    // 참고 https://st-lab.tistory.com/252
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long[][] A = {{1, 1}, {1, 0}};
        System.out.println(dfs(A, n-1)[0][0]);
    }

    static long[][] dfs(long[][] matrix, long exp) {
        if (exp == 1 || exp == 0 ){
            return matrix;
        }
        long[][] result = dfs(matrix, exp/2);

        result = matrixPow(result, result);

        if (exp % 2 != 0){
            result = matrixPow(result, new long[][]{{1, 1}, {1, 0}});
        }
        return result;
    }

    private static long[][] matrixPow(long[][] r1, long[][] r2) {
        long[][] ret = new long[2][2];
        for (int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                for(int k = 0; k < 2; k++){
                    ret[j][k] += r1[j][i] * r2[i][k];
                    ret[j][k] %= MOD;
                }
            }
        }
        return ret;
    }
}
