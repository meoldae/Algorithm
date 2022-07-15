#Baekjoon 2630
import sys
input = sys.stdin.readline

def solution(x, y, N):
    global white, black, board
    
    color = board[x][y]
    for row in range(x, x+N):
        for col in range(y, y+N):
            if board[row][col] != color:
                N //= 2
                solution(x, y+N, N)        # 1
                solution(x, y, N)        # 2
                solution(x+N, y, N)        # 3
                solution(x+N, y+N, N)        # 4
                return 
    if color == 0:
        white += 1
    else:
        black += 1

    return

n = int(input())
white = 0
black = 0
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))

solution(0, 0, n)

print(white)
print(black)