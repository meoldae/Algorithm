package KY_OpenContest_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_Parity_Constraint_Closest_Pair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) points[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(points);

        int oddDistance = Integer.MAX_VALUE;
        int evenDistance = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int[] diff = BinarySearch(points, points[i]);
            evenDistance = Math.min(evenDistance, diff[0]);
            oddDistance = Math.min(oddDistance, diff[1]);
        }
        System.out.print((evenDistance != Integer.MAX_VALUE) ? evenDistance : -1);
        System.out.print(" ");
        System.out.print((oddDistance != Integer.MAX_VALUE) ? oddDistance : -1);
    }

    static int[] BinarySearch(int[] points, int target){
        int left = 0;
        int right = points.length - 1;
        int[] diff = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        while(left < right){
            int mid = (left + right) / 2;
            if (points[mid] == target) return diff;
            else if (points[mid] > target) right = mid - 1;
            else left = mid + 1;

            int value = Math.abs(points[mid] - target);
            if (value % 2 == 0) diff[0] = Math.min(diff[0], value);
            else diff[1] = Math.min(diff[1], value);
        }
        return diff;
    }
}