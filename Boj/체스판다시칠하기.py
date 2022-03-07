n, m = map(int, input().split())
board = []
answer = []

for i in range(n):
    board.append(input())
    
# 8칸 자를 수 있는만큼까지 
for i in range(n-7):
    for j in range(m-7):
        w_start = 0
        b_start = 0
        # 8칸 탐색
        for row in range(i, i+8):
            for col in range(j, j+8):
                # row + col 짝수이면 원점이랑 색 같아야 함 
                if (row+col)%2 == 0:
                    if board[row][col] == 'W':
                        w_start += 1
                    else:
                        b_start += 1
                else:
                    if board[row][col] == 'W':
                        b_start += 1
                    else:
                        w_start += 1
        answer.append(min(w_start, b_start))
print(min(answer))