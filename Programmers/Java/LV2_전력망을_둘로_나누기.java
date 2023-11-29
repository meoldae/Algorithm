public class LV2_전력망을_둘로_나누기 {
    public static int[] p;
    public int solution(int n, int[][] wires) {
        p = new int[n + 1];
        int answer = 100;
                
        for (int i = 0; i < wires.length; i++) {
			
            initArr();
            
			for (int j = 0; j < wires.length; j++) {
				if (i == j) continue;
                int x = wires[j][0];
                int y = wires[j][1];
                union(x, y);
			}

            int temp = 0;
            for (int j = 1; j < n + 1; j++) {
                if (find(p[j]) == 1) temp++;
            }
            answer = Math.min(answer, Math.abs(n - temp * 2));
        }
        return answer;
    }
    
    public void initArr() {
        for (int i = 1; i < p.length; i++) {
            p[i] = i;
        }
    }
        
    public int find(int x) {
        if (x == p[x]) {
            return x;
        } else {
            return p[x] = find(p[x]);
        }
    }
    
    public void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if (!isSameParent(x, y)) {
            if (x <= y) p[y] = x;
            else p[x] = y;
        }
    }
    
    public boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }
}