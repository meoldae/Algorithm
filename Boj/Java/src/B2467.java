import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2467 {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dissolve = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int left = 0;
        int right = n-1;
        int value = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (left < right){
            int sum = dissolve[left] + dissolve[right];
            if (value > Math.abs(sum)){
                value = Math.abs(sum);
                answer[0] = left;
                answer[1] = right;
            }
            if (sum > 0) {
                right--;
            }else {
                left++;
            }
        }
        System.out.println(dissolve[answer[0]] + " " + dissolve[answer[1]]);
    }
}
