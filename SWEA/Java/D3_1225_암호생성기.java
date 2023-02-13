import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class D3_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tc = "";
        StringBuilder sb = new StringBuilder();
        while ((tc = br.readLine()) != null) {
            Queue<Integer> queue = new ArrayDeque<>();
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(queue::add);

            int counter = 0;
            while (true) {
                counter = (counter % 5) + 1;
                int now = queue.poll();
                queue.add(Math.max(now - counter, 0));
                if (now - counter <= 0) break;
            }

            sb.append("#").append(tc).append(" ");
            queue.stream().forEach(num -> sb.append(num).append(" "));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
