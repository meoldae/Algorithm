import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B19539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = 0;
        int largeCount = 0;
        for (int i = 0; i < N; i++) {
            int goal = Integer.parseInt(st.nextToken());
            total += goal;
            largeCount += goal / 2;
        }

        boolean flag = true;
        if (total % 3 != 0) flag = false;
        if (largeCount < total / 3) flag = false;

        System.out.print(flag ? "YES" : "NO");
    }
}
