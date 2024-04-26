import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class B15665 {
    static int N, M;
    static int[] numbers;
    static Set<Integer> numberSet;
    static int[] selected;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        numberSet = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) numberSet.add(Integer.parseInt(st.nextToken()));

        numbers = numberSet.stream().mapToInt(Integer::intValue).toArray();
        backTracking(0);
        System.out.print(sb);

    }

    static void backTracking(int count) {
        if (count == M) {
            for (int num : selected) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            selected[count] = numbers[i];
            backTracking(count + 1);
        }
    }
}
