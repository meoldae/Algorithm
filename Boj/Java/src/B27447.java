import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B27447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] customer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int success = 0;
        int time = 0;
        int coffee = 0;
        int cup = 0;

        while (success < n) {
            if (time == customer[success]){
                if (coffee > 0) {
                    coffee--;
                    success++;
                    time++;
                    continue;
                }
                else {
                    System.out.println("fail");
                    return;
                }
            }

            if (success + coffee < n && time + m >= customer[success + coffee]) {
                if (cup > 0) {
                    cup--;
                    coffee++;
                } else cup++;
            }else {
                cup++;
            }
            time++;
        }
        System.out.print("success");
    }
}