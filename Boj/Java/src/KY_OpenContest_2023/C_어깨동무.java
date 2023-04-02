package KY_OpenContest_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_어깨동무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        if (N == K){
            System.out.print(0);
            return;
        }

        int[] students = new int[N];
        for (int i = 0; i < N; i++) students[i] = Integer.parseInt(st.nextToken());
        int[] diff = new int[N];

        int left = Integer.MAX_VALUE;
        int right = 0;
        for (int i = 0; i < N; i++) {
            if (i < N - 1) diff[i] = Math.max(diff[i], Math.abs(students[i] - students[i + 1]));
            if (i > 0) diff[i] = Math.max(diff[i], Math.abs(students[i]- students[i - 1]));
            left = Math.min(left, diff[i]);
            right = Math.max(right, diff[i]);
        }

        while(left <= right) {
            int mid = (left + right) / 2;
            int count = 0; // 지친사람
            for (int d : diff) if (d > mid) count++;

            if (count > K) { // 지친 사람이 K보다 많으면 점수차가 커져야 함
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
