import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Comparator;

class Solution {
    static boolean[][] visited;
    static char[][] parse;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList();
        parse = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        
        for (int i = 0; i < maps.length; i++) parse[i] = maps[i].toCharArray();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (!visited[i][j] && parse[i][j] != 'X') {
                    answer.add(bfs(i,j));
                }
            }
        }
        
        if (answer.size() == 0) return new int[]{-1};
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    
    public int bfs(int x, int y) {
        int count = Character.getNumericValue(parse[x][y]);
        Queue<int[]> queue = new ArrayDeque();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];
                
                if (nx >= parse.length || nx < 0 || ny >= parse[x].length || ny < 0) continue;
                if (visited[nx][ny] || parse[nx][ny] == 'X') continue;
                
                count += Character.getNumericValue(parse[nx][ny]);
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = true;   
            }
        }
        return count;
    }
}