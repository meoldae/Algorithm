import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++){
            double[] input = Arrays.stream(br.readLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            double d = Math.pow(Math.pow(input[3] - input[0], 2) + Math.pow(input[4] - input[1], 2), 1.0/2.0);

            if (d == 0 && input[2] == input[5]) { // 중심이 같고, 반지름이 같으면 == 정확히 일치
                System.out.println(-1);
            }else if (input[2] + input[5] == d || Math.abs(input[5] - input[2]) == d) {
                // 외접이거나, 내접이라면
                System.out.println(1);
            }else if (Math.abs(input[5] - input[2]) < d && d < input[2] + input[5]){
                // 두 중심 사이 거리가 반지름 차이보다 크고, 합보다 작으면
                System.out.println(2);
            }else {
                System.out.println(0);
            }
        }
    }
}
