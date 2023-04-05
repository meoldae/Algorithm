import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B7575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<int[]> programs = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            programs.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        programs.sort((o1, o2) -> o2.length - o1.length);

        int[] virus = new int[K];

        for (int i = 0; i <= programs.get(0).length - K; i++) {
            // Virus 추정
            for (int j = 0; j < K; j++) {
                virus[j] = programs.get(0)[i + j];
            }

            if(kmp(programs, virus)) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
    static boolean kmp(List<int[]> programs, int[] virus) {
        int l = virus.length;
        int[] reverse = new int[l];
        for (int i = 0; i < l; i++) reverse[i] = virus[l - i - 1];
        int[] pattern = new int[l];
        int[] rPattern = new int[l];

        int j1 = 0, j2 = 0;
        // 부분 일치 테이블 생성
        for (int i = 1; i < l; i++) {
            while(j1 > 0 && virus[i] != virus[j1]) j1 = pattern[j1 - 1]; // 전 단계 일치만큼 스킵

            if (virus[i] == virus[j1]) pattern[i] = ++j1;
            else pattern[i] = 0;

            while(j2 > 0 && reverse[i] != reverse[j2]) j2 = rPattern[j2 - 1]; // 전 단계 일치만큼 스킵

            if (reverse[i] == reverse[j2]) rPattern[i] = ++j2;
            else rPattern[i] = 0;
        }
        // 프로그램들 순회
        int count = 0;
        for (int[] program : programs) {
            j1 = 0;
            j2 = 0;
            for (int i = 0; i < program.length; i++) {
                // 정방향 일치
                while(j1 > 0 && program[i] != virus[j1]) j1 = pattern[j1 - 1]; // 전 단계 일치만큼 스킵
                if (program[i] == virus[j1]) { // 일치 문자열이 virus 만큼 있다면
                    if (j1++ == l - 1) { // count 를 하나 증가시키고 다음 프로그램으로
                        count++;
                        break;
                    }
                }
                // 역방향 일치
                while(j2 > 0 && program[i] != reverse[j2]) j2 = rPattern[j2 - 1];
                if (program[i] == reverse[j2]) {
                    if (j2++ == l - 1) {
                        count++;
                        break;
                    }
                }
            }
        }
        // 모든 프로그램에 Virus 추정 문자열이 존재한다면 리턴 true
        return count == programs.size();
    }
}
