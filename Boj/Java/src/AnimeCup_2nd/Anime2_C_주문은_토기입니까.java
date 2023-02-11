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
        int successed = 0;
        int time = 0;
        int cup = 0;
        int coffee = 0;
        while (time <= customer[customer.length-1]){
            if (time == customer[successed]){
                if (coffee > 0){
                    System.out.println("커피 배달");
                    successed++;
                    coffee--;
                    time++;
                    continue;
                } else {
                    System.out.println("손님 화냄.. Break");
                    flag = false;
                    break;
                }
            }
            if (customer[successed] - time <= m) {
                if (cup > 0){
                    System.out.println("커피 생성");
                    cup--;
                    coffee++;
                    time++;
                    continue;
                }else{
                    System.out.println("컵 생성");
                    cup++;
                }
            }else{
                System.out.println("컵 생성");
                cup++;
            }
            time++;
        }
        if (flag) System.out.print("success");
        else System.out.println("fail");
    }
}
