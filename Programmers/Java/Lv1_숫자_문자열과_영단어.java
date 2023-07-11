public class Lv1_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";

        String[][] str = {{"one", "1"}, {"two", "2"}, {"three", "3"}, {"four", "4"},
                {"five", "5"}, {"six", "6"}, {"seven", "7"}, {"eight", "8"},
                {"nine", "9"}, {"zero", "0"}};

        for (String[] change : str) {
            s = s.replaceAll(change[0], change[1]);
        }


        int answer = Integer.parseInt(s);
    }
}
