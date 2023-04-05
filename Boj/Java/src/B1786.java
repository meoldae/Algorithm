import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class B1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();

        int[] pattern = new int[P.length];
        int j = 0;
        for (int i = 1; i < P.length; i++) {
            /*
            j가 0보다 크고 ( 앞서서 일치한 부분이 있고 )
            현재 문자열과 부분 문자열(패턴)이 다르면 j = 이전까지 일치한 문자열의 길이
            => 일치한 문자열을 기억하고 그만큼 연산 생략
             */
            while (j > 0 && P[i] != P[j]) j = pattern[j - 1];

            // 문자열과 부분 문자열이 같으면 현재 부분 문자열 길이 ++
            if (P[i] == P[j]) pattern[i] = ++j;
                // j == 0 이고 다르면 공통 부분 문자열 없음
            else pattern[i] = 0;
        }

        int answer = 0;
        List<Integer> list = new LinkedList<>();
        j = 0;
        for (int i = 0; i < T.length; i++) {
            /*
            동일하게 앞서서 일치한 부분이 있고
            현재 문자열과 부분 문자열이 다르다면 j에 이전까지 일치한 문자열의 길이
            => 연산 생략
             */
            while (j > 0 && T[i] != P[j]) j = pattern[j - 1];

            if (T[i] == P[j]) {
                if (j++ == P.length - 1) {
                    answer++;
                    list.add(i - j + 2);
                    j = pattern[j - 1];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        for (int idx : list) sb.append(idx).append(" ");
        System.out.print(sb);
    }
}
