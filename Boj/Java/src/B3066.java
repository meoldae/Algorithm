import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++){
            int N = Integer.parseInt(br.readLine());
            int[] ports = new int[N];
            for (int i = 0; i < N; i++){
                ports[i] = Integer.parseInt(br.readLine());
            }
            int[] lis = new int[N + 1];
            int count = 0;
            for (int port : ports){
                if (lis[count] < port)lis[++count] = port;
                else {
                    int idx = binarySearch(lis, count, port);
                    lis[idx] = port;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
    static int binarySearch(int[] lis, int right, int target){
        int left = 0;
        while (left < right){
            int mid = (left + right) / 2;
            if (lis[mid] < target) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}
