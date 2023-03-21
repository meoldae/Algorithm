import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] polls = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) polls[i] = Integer.parseInt(st.nextToken());

        int[] lis = new int[N+1];
        int count = 0;

        for (int i = 0; i < N; i++){
            if(lis[count] < polls[i]){
                lis[++count] = polls[i];
            }else {
                int idx = binarySearch(lis, count, polls[i]);
                lis[idx] = polls[i];
            }
        }
        System.out.print(N-count);
    }

    static int binarySearch(int[] lis, int right, int target){
        int left = 0;
        while(left < right){
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
