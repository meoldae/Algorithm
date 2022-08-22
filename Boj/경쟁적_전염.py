#Baekjoon 18405
import sys
from collections import deque
input = sys.stdin.readline

def solution():
    n, k = map(int, input().split())

    for_queue = []
    board = []

    for i in range(n):
        viruses = list(map(int, input().split()))
        board.append(viruses)
        
        for j in range(n):
            if viruses[j] != 0:
                for_queue.append([viruses[j], i, j])   

    s, dst_x, dst_y = map(int, input().split())     
            
    for_queue.sort()
    queue = deque(for_queue)
    count = 0 
    dx = [0, 0, -1, 1]
    dy = [1, -1, 0, 0]

    while queue:    
        if count == s:
            return board[dst_x-1][dst_y-1]
        for _ in range(len(queue)):
            level, x, y = queue.popleft()
            for d in range(4):     
                nx = x + dx[d]
                ny = y + dy[d]
                if nx >= 0 and nx < n and ny >= 0 and ny < n:
                    if board[nx][ny] == 0:
                        board[nx][ny] = level
                        queue.append((level, nx, ny))
        count += 1
    return board[dst_x-1][dst_y-1]
    
print(solution())