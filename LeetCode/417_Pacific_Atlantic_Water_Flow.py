# height = 섬의 [r][c] 지점의 높이
# 이웃한 섬의 좌표가 현재 지점보다 낮거나 같으면 흐를 수 있다
# Pacific Atlantic으로 모두 흐를 수 있는 좌표를 구하라?
from typing import List
from collections import deque
def bfs(row, col, heights):
    visited = set()
    
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
        
    pacific = False
    atlantic = False
    
    queue = deque()
    queue.append([row, col])
    visited.add((row, col))
    
    while queue:
        x, y = queue.popleft()
                                  
        for i in range(4):

            nx = x+dx[i]
            ny = y+dy[i]
        
            if nx < 0 or ny < 0:
                pacific = True

                if (pacific is True) and (atlantic is True):
                    queue.clear()
                    return True
                else:
                    continue
                
            elif nx >= len(heights) or ny >= len(heights[nx]):
                atlantic = True

                if (pacific is True) and (atlantic is True):
                    queue.clear()
                    return True
                
                else:
                    continue

            if (nx, ny) not in visited and heights[x][y] >= heights[nx][ny]:
                queue.append([nx, ny])
                visited.add((nx, ny))

    else:
        queue.clear()
        return False
        
class Solution:        
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        answer = []
        for row in range(len(heights)):
            for col in range(len(heights[row])):
                check = bfs(row, col, heights)
                if check:
                    answer.append([row, col])
        return answer
    
    
    
if __name__ == '__main__':
    sol = Solution()
    heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    #heights = [[2,1], [1,2]]
    #heights = [[1,1],[1,1],[1,1]]

    result = sol.pacificAtlantic(heights=heights)
    print(result) 
    
    
    
if __name__ == '__main__':
    sol = Solution()
    heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    #heights = [[2,1], [1,2]]
    #heights = [[1,1],[1,1],[1,1]]

    result = sol.pacificAtlantic(heights=heights)
    print(result) 