import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B20920 {

    static class Word {
        String word;
        int count;

        public Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;

            int count = 1;
            if (dict.containsKey(word)) count = dict.get(word) + 1;

            dict.put(word, count);
        }

        List<String> list = new ArrayList<>();
        for (String s : dict.keySet()) {
            list.add(s);
        }

        list.sort((o1, o2) -> {
            if (dict.get(o1) == dict.get(o2)) {
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                else return o2.length() - o1.length();
            } else return dict.get(o2) - dict.get(o1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
