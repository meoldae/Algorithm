import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class D3_1228_암호문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int tc = 1;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            ArrayList<String> list = new ArrayList<>(Arrays.asList(br.readLine().split(" ")));

            int r = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                String command = st.nextToken();
                int start = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                for (int i = 0; i < count; i++){
                    list.add(start+i, st.nextToken());
                }
            }
            sb.append("#").append(tc++).append(" ");
            IntStream.range(0, 10).forEach(num -> sb.append(list.get(num)).append(" "));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}