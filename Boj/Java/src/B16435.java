import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] l = new int[]{Integer.parseInt(st.nextToken())};
        int[] fruits = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        Arrays.stream(fruits).filter(fruit -> fruit <= l[0]).forEach(fruit -> l[0]++);
        System.out.print(l[0]);
    }
}