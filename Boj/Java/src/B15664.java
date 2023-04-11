import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B15664 {
    static int N, M;
    static int[] nums, answer;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        answer = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);
        backTrack(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String s : set) sb.append(s).append("\n");
        System.out.print(sb);
    }

    static void backTrack(int count, int start){
        if (count == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) sb.append(answer[i]).append(" ");
            set.add(sb.toString());
            return;
        }

        for (int i = start; i < N; i++) {
            answer[count] = nums[i];
            backTrack(count + 1, i + 1);
        }
    }
}
