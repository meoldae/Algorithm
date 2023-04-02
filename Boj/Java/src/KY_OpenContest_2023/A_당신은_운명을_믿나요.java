package KY_OpenContest_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_당신은_운명을_믿나요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] S = br.readLine().toCharArray();
        int Y = 0;
        int K = 0;
        char[] YONSEI = {'Y', 'O', 'N', 'S', 'E', 'I'};
        char[] KOREA = {'K', 'O', 'R', 'E', 'A'};

        for (char c : S) {
            if (c == YONSEI[Y]) {
                Y++;
                if (Y >= YONSEI.length){
                    System.out.print("YONSEI");
                    return;
                }
            }
            if (c == KOREA[K]) {
                K++;
                if (K >= KOREA.length) {
                    System.out.print("KOREA");
                    return;
                }
            }
        }
    }
}

