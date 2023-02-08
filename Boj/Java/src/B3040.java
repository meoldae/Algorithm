import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3040 {
    static int[] numbers;
    static int[] answer;
    static boolean flag;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numbers = new int[9];
        answer = new int[7];
        for (int i = 0; i < 9; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }
        comb(0, 0);
        System.out.println(sb.toString());
    }
    static void comb(int start, int count){
        if (flag) return;
        if (count >= 7){
            int sum = 0;
            for (int i = 0; i < 7; i++) sum += answer[i];
            if (sum == 100){
                Arrays.stream(answer).forEach(num -> sb.append(num).append("\n"));
                flag = true;
            }
            return;
        }
        for (int i = start; i < 9; i++){
            answer[count] = numbers[i];
            comb(i+1, count+1);
        }
    }
}
