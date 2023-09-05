import java.util.Arrays;

public class Lv2_H_index {
	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		for (int i = citations.length; i > 0; i--) {
			int idx = Arrays.binarySearch(citations, i);
			if (idx < 0) idx = (idx * -1) - 1;
			if (citations.length - idx >= i) {
				answer = Math.max(i, answer);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		// int[] citations = {0,0,0,0,4};
		System.out.println("Answer : " + solution(citations));

	}
}
