import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        outer:
        while ((input = br.readLine()) != null) {
            int hole = Integer.parseInt(input);
            hole *= 10000000;

            int legos = Integer.parseInt(br.readLine());
            int[] lego = new int[legos];
            for (int i = 0; i < legos; i++) lego[i] = Integer.parseInt(br.readLine());
            Arrays.sort(lego);

            int left = 0;
            int right = legos - 1;

            while (left < right) {
                int sum = lego[left] + lego[right];

                if (sum < hole) left++;
                else if (sum == hole) {
                    sb.append("yes").append(" ").append(lego[left]).append(" ").append(lego[right]).append("\n");
                    continue outer;
                } else right--;
            }
            sb.append("danger").append("\n");
        }
        System.out.print(sb);
    }
}
