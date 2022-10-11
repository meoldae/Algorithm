#Baekjoon 16928
import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    board = [i for i in range(101)]
    n, m = map(int, input().split())

    for _ in range(n):
        x, y = map(int, input().split())
        board[x] = y
        
    for _ in range(m):
        u, v = map(int, input().split())
        board[u] = v
        
    queue = deque()
    queue.append([1, 0])
    visited = [0] * 101
    visited[1] = 1
    
    while queue:
        idx, count = queue.popleft()

        for i in range(1, 7):
            next_idx = idx + i
            
            if next_idx > 0 and next_idx <= 100:
                if board[next_idx] != next_idx: # 뱀 OR 사다리
                    visited[next_idx] = 1
                    next_idx = board[next_idx]
                    queue.append([next_idx, count+1])
            
                if next_idx == 100:
                    print(count+1)
                    return
                
                else:
                    if visited[next_idx] == 0:
                        queue.append([next_idx, count+1])
                        visited[next_idx] = 1
    return

if __name__ == '__main__':
    bfs()