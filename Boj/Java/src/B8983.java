import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B8983 {
    static int[] point;
    static int M, N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        point = new int[M];
        for (int i = 0; i < M; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(point);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y > L) continue; // 직선으로 쏴도 벗어날 경우

            int rangeL = x - (L - y);
            int rangeR = Math.min(1000000000, x + (L - y));

            if (binarySearch(rangeL, rangeR)) answer ++;
        }
        System.out.print(answer);
    }

    static boolean binarySearch(int rangeL, int rangeR) {
        int left = 0;
        int right = M;

        while (left < right) {
            int mid = (left + right) / 2;
            if (point[mid] < rangeL) {
                left = mid + 1;
            } else if (point[mid] > rangeR){
               right = mid;
            } else {
                return true;
            }
        }
        return false;
    }
}