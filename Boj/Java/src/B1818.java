import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] books = new int[N];
        int[] lis = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) books[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int book : books) {
            if (book > lis[count]) lis[++count] = book;
            else {
                int idx = binarySearch(lis, count, book);
                lis[idx] = book;
            }
        }
        System.out.print(N - count);
    }

    static int binarySearch(int[] lis, int right, int target){
        int left = 0;
        while(left < right) {
            int mid = (left + right) / 2;
            if (target > lis[mid]) left = mid + 1;
            else right = mid;
        }
        return right;
    }
}