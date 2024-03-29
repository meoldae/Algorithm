import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17478 {
    static String[] phrases;
    static String underBar = "____";
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        phrases = new String[5];
        phrases[0] = "\"재귀함수가 뭔가요?\"";
        phrases[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
        phrases[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
        phrases[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
        phrases[4] = "라고 답변하였지.";

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursion(0, n);
    }

    static void recursion(int start, int n) {

        System.out.print(sb.toString());
        System.out.println(phrases[0]);
        if (start == n) {
            System.out.print(sb.toString());
            System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.print(sb.toString());
            System.out.println(phrases[4]);
            return;
        }
        for (int i = 1; i <= 3; i++){
            System.out.print(sb.toString());
            System.out.println(phrases[i]);
        }
        sb.append(underBar);
        recursion(start + 1, n);
        sb.delete(sb.length() - 4, sb.length());

        System.out.print(sb.toString());
        System.out.println(phrases[4]);
    }
}
