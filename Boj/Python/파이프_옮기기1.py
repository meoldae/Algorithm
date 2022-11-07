#Baekjoon 17070
import sys
input = sys.stdin.readline

def dfs(loc, direction):
    global n, answer, board
        
    if loc[0] == n-1 and loc[1] == n-1:
        answer += 1
    
    if direction == 0 or direction == 1: # 가로, 대각선 -> 가로
        next_loc = [loc[0], loc[1]+1]
        if 0 <= next_loc[1] < n and board[next_loc[0]][next_loc[1]] != 1:
            dfs(next_loc, 0)
                    
    if direction == 2 or direction == 1: # 세로, 대각선 -> 세로
        next_loc = [loc[0] + 1, loc[1]]
        if 0 <= next_loc[0] < n and board[next_loc[0]][next_loc[1]] != 1:                    
            dfs(next_loc, 2)
        
    if direction == 0 or direction == 1 or direction == 2: # 가로, 대각선, 세로 -> 대각선
        next_loc = [loc[0] + 1, loc[1] + 1]
        if 0 <= next_loc[0] < n and 0 <= next_loc[1] < n:
            if board[loc[0]][next_loc[1]] == 0 and board[next_loc[0]][loc[1]] == 0 and board[next_loc[0]][next_loc[1]] == 0:
                dfs(next_loc, 1)
    return

if __name__ == '__main__':
    n = int(input())
    answer = 0
    board = []
    first = [0, 1]
    for _ in range(n):
        board.append(list(map(int, input().split())))
        
    dfs(first, 0)
    print(answer)