import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sugar = Integer.parseInt(br.readLine());
        int answer = 0;
        while (sugar >= 0){
            if (sugar % 5 == 0){
                answer += sugar / 5;
                break;
            }
            sugar -= 3;
            answer++;
        }
        if (sugar < 0) System.out.println(-1);
        else System.out.println(answer);
    }
}
