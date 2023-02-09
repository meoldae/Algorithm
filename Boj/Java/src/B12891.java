import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class B12891 {
    static int s, p;
    static int[] limit;
    static char[] input;
    static int answer;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        input = br.readLine().toCharArray();
        limit = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        count = new int[4];
        IntStream.range(0, p).forEach(num -> counting(num, true));
        check();

        for (int i = 0; i < s - p; i++) {
            counting(i, false);
            counting(i+p, true);
            check();
        }
        System.out.println(answer);
    }

    static void check() {
        for (int i = 0; i < 4; i++){
            if (count[i] < limit[i]) return;
        }
        answer++;
    }

    static void counting(int idx, boolean flag) {
        int weight = flag ? 1 : -1;
        switch (input[idx]) {
            case 'A':
                count[0] += weight;
                break;
            case 'C':
                count[1] += weight;
                break;
            case 'G':
                count[2] += weight;
                break;
            case 'T':
                count[3] += weight;
                break;
        }
    }
}