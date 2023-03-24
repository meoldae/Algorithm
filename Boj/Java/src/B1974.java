import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1974 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());

            int[] trophies = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) trophies[i] = Integer.parseInt(st.nextToken());

            int[] lis = new int[N+1];
            int[] lisIdx = new int[N];
            int count = 0;

            for (int i = 0; i < N; i++){
                if (lis[count] < trophies[i]){
                    lis[++count] = trophies[i];
                    lisIdx[i] = count;
                }else {
                    int idx = binarySearch(lis, count, trophies[i]);
                    lis[idx] = trophies[i];
                    lisIdx[i] = idx;
                }
            }
            sb.append(count).append("\n");
            Stack<Integer> stack = new Stack<>();
            for (int i = N-1; i >= 0; i--){
                if (count <= 0) break;
                if (lisIdx[i] == count) {
                    stack.push(i + 1);
                    count--;
                }
            }
            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static int binarySearch(int[] lis, int right, int target){
        int left = 0;
        while (left < right){
            int mid = (left + right) / 2;
            if (lis[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
