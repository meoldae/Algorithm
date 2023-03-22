import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> polls = new ArrayList<>();
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            polls.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        polls.sort((o1, o2) -> o1[0] - o2[0]);

        int[] lis = new int[N + 1];
        int[] lisIdx = new int[N];

        int count = 0;
        for (int i = 0; i < polls.size(); i++) {
            int[] poll = polls.get(i);
            if (lis[count] < poll[1]) {
                lis[++count] = poll[1];
                lisIdx[i] = count;
            } else {
                int idx = binarySearch(lis, count, poll[1]);
                lis[idx] = poll[1];
                lisIdx[i] = idx;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(N - count).append("\n");

        Stack<Integer> stack = new Stack<>();
        for (int i = N-1; i >= 0; i--){
            if (lisIdx[i] == count && count > 0) {
                count--;
            }
            else if (lisIdx[i] != count){
                stack.push(polls.get(i)[0]);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop()).append("\n");
        }
        System.out.print(sb);

    }

    static int binarySearch(int[] lis, int right, int target) {
        int left = 0;
        while (left < right){
            int mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }
}
