package AnimeCup_2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Anime2_C_주문은_토기입니까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] customer = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        boolean flag = true;
        int success = 0;
        int time = 0;
        int cup = 0;
        int coffee = 0;

        while (success < n && time <= customer[n-1]) {
            if (time == customer[success]) {
                if (coffee > 0) {
                    coffee--;
                    success++;
                } else {
                    flag = false;
                    break;
                }
            } else if (time >= customer[success] - m) {
                if (cup > 0){
                    coffee++;
                    cup--;
                } else {
                    cup++;
                }
            } else {
                cup++;
            }
            time++;
        }
        if (flag) System.out.println("success");
        else System.out.println("fail");
    }
}