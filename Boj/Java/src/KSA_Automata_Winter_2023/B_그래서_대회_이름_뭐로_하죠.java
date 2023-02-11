package KSA_Automata_Winter_2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_그래서_대회_이름_뭐로_하죠 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        int a = 0;
        char v = 'A';
        List<Character> list = new ArrayList<>();
        for (char c : s) {
            if (c == 65) {
                a++;
            } else if (c != 69 && c != 73 && c != 79 && c != 85) {
                v = c;
            }
            list.add(c);
        }

        if (a >= 2 && v != 65) {
            for (char c : new char[]{v, 'A', 'A'}) {
                list.remove(list.indexOf(c));
            }

            StringBuilder sb = new StringBuilder();
            sb.append("YES\n");
            for (int i = 0; i < m - 3; i++) {
                sb.append(list.get(i));
            }
            sb.append('A').append('A').append(v);
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }
    }
}