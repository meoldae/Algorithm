import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1289_원재의_메모리_복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            char[] input = br.readLine().toCharArray();
            int answer;
            int count = 0;
            for (int i = 0; i < input.length; i++){
                if (input[i] == '1') count++;
            }
            if (count % 2 == 0){
                answer = count / 2;
            }
            else {
                answer = (int) (Math.ceil(count / 2.0) + 1);
            }
            System.out.printf("#%d %d%n", tc, answer);
        }
    }
}
