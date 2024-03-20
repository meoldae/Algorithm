import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B26091 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] members = new int[N];
        for (int i = 0; i < N; i++) {
            members[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(members);
        int right = N - 1;
        int left = 0;

        int answer = 0;
        while (left < right) {
            if (members[left] + members[right] >= M) {
                answer++;
                left++;
                right--;
            } else {
                left++;
            }
        }
        System.out.print(answer);
    }
}
