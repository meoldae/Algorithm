#Baekjoon 14500
import sys
input = sys.stdin.readline

def dfs(blockCount, x, y, value):
    global answer
    global visited
    global board
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= 0 and nx < len(board) and ny >= 0 and ny < len(board[0]): 
            if visited[nx][ny] == 0:
                if blockCount == 1:
                    answer = max(answer,value + board[nx][ny])
                else:
                    visited[nx][ny] = 1
                    if blockCount == 2:
                        dfs(blockCount-1, x, y, value+board[nx][ny]) # T-mino Count
                    dfs(blockCount-1, nx, ny, value+board[nx][ny])
                    visited[nx][ny] = 0
    return

if __name__ == '__main__':
    n, m = map(int, input().split())

    board = []
    for _ in range(n):
        board.append(list(map(int, input().split())))

    visited = [[0]*m for _ in range(n)]
    answer = 0
    for i in range(n):    
        for j in range(m):
            visited[i][j] = 1
            dfs(3, i, j, board[i][j])   # For General Mino
            visited[i][j] = 0
    print(answer)