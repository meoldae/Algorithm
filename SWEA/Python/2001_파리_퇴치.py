def check(row, col) -> int:
    answer = 0
    for r in range(row, row+m):
        for c in range(col, col+m):
            answer += board[r][c]
    return answer

t = int(input())

for i in range(1, t+1):
    n, m = map(int, input().split())
    board = []
    for _ in range(n):
        board.append(list(map(int, input().split())))
    
    answer = 0
    
    for row in range(n-m+1):
        for col in range(n-m+1):
            answer = max(answer, check(row, col))
            
    print("#{} {}".format(i, answer))