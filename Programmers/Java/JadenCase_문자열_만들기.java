public class JadenCase_문자열_만들기 {
    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "for the  last week";

        Solution solution = new Solution();
        System.out.println(solution.solution(s2));
    }
}

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toLowerCase().toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (i == 0) {
                sb.append(Character.toUpperCase(charArr[i]));
            } else {
                if (charArr[i - 1] == ' ' && charArr[i] != ' ') {
                    sb.append(Character.toUpperCase(charArr[i]));
                } else sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }
}
