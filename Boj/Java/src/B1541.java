import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String[] input = br.readLine().split("-");
        for (String s : input[0].split("\\+")){
            answer += Integer.parseInt(s);
        }

        for (int i = 1; i < input.length; i++){
            for (String s : input[i].split("\\+")){
                answer -= Integer.parseInt(s);
            }
        }

        System.out.print(answer);

    }
}
