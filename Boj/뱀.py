import sys
input = sys.stdin.readline

n = int(input())
k = int(input())

board = [[0]*n for _ in range(n)]
snake = [(0, 0)]

# for debugging
# apples = []
for i in range(k):
    x, y = map(int, input().split())
    board[x-1][y-1] = 1
    # apples.append((x-1, y-1))

L = int(input())
direction_change = dict()
for i in range(L):
    t, direction = input().split()
    if direction == 'D':
        direction_change[int(t)] = 1
    else:
        direction_change[int(t)] = -1

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
# 1:Right  2:Down  3:Left  4:Up
# R:+  L:-
d = 0
# First Direction is Right
time = 0
while True:
    if time in direction_change:
        d += direction_change[time]
        if d < 0: d = 3
        elif d > 3: d = 0
            
    # Head location
    x, y = snake[0]
    nx = x + dx[d]
    ny = y + dy[d]
    
    # Game Over
    if ((nx, ny) in snake) or nx < 0 or nx >= n or ny < 0 or ny >= n:
        print(time+1)
        break
    
    # Head move
    snake.insert(0, (nx, ny))
    # Not in apple in next space, remove tail
    if board[nx][ny] != 1:
        del snake[-1]
    
    # Remove eaten apple
    else:
        board[nx][ny] = 0
            
    time += 1