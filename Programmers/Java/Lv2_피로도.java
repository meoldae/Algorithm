class Lv2_피로도 {
	static int[] numbers;
	static boolean[] isSelected;
	static int answer;

	static int solution(int k, int[][] dungeons){
		answer = 0;
		numbers = new int[dungeons.length];
		isSelected = new boolean[dungeons.length];

		permutation(0, dungeons, k);

		return answer;
	}

	static int explore(int[] order, int[][] dungeons, int fatigue) {
		int result = 0;
		for (int o : order) {
			if (fatigue < dungeons[o][0]) return result;
			fatigue -= dungeons[o][1];
			result++;
		}

		return result;
	}

	static void permutation(int count, int[][] dungeons, int fatigue){
		if (count == numbers.length) {
			answer = Math.max(answer, explore(numbers, dungeons, fatigue));
		}
		for (int i = 0; i < numbers.length; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				numbers[count] = i;

				permutation(count + 1, dungeons, fatigue);
				isSelected[i] = false;
			}
		}
	}
}