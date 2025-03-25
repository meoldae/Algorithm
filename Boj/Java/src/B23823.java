import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B23823 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int q = Integer.parseInt(input[1]);
        int[][] cake = new int[2][N];
        
        int[] max = new int[2];
        int[] maxValue = new int[2];
        for (int i = 0; i < q; i++) {
            input = br.readLine().split(" ");
            int t = Integer.parseInt(input[0]) - 1;
            int a = Integer.parseInt(input[1]) - 1;
            
            if (++cake[t][a] > max[t]) {
                max[t] = cake[t][a];
                maxValue[t] = 1;
            } else if (cake[t][a] == max[t]) {
                maxValue[t]++;
            }
            sb.append((maxValue[0] == 0 ? N : maxValue[0]) * (maxValue[1] == 0 ? N : maxValue[1])).append("\n");
        }
        System.out.println(sb.toString());
    }    
}
