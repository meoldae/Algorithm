class Lv2_피로도_DFS {
	static boolean[] visited;
	static int answer;
	static void dfs(int fatigue, int[][] dungeons, int count) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && fatigue >= dungeons[i][0]) {
				visited[i] = true;
				dfs(fatigue - dungeons[i][1], dungeons, count + 1);
				visited[i] = false;
			}
		}
		answer = Math.max(answer, count);
	}

	static int solution(int k, int[][] dungeons){
		visited = new boolean[dungeons.length];

		dfs(k, dungeons, 0);

		return answer;
	}
}