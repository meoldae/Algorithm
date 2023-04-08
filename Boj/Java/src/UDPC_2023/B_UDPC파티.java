package UDPC_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_UDPC파티 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] UDPC = new int[4];

        for (char vote : input) {
            if (vote == 'U' || vote == 'C') {
                UDPC[0]++;
            } else {
                UDPC[1]++;
                UDPC[2]++;
            }
        }

        if (Math.ceil(UDPC[1] / 2.0) < UDPC[0]) {
            System.out.print('U');
        }
        if (UDPC[1] > 0) {
            System.out.println("DP");
        }
    }
}
