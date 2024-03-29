import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] record = new int[n];
        StringBuilder sb = new StringBuilder();
        List<Integer> answer = new LinkedList<>();

        for (int i = 0; i < n; i++) record[i] = Integer.parseInt(st.nextToken());
        for (int i = n - 1; i >= 0; i--) answer.add(record[i], (i + 1));
        for (int a : answer) sb.append(a).append(" ");
        System.out.print(sb);
    }
}
