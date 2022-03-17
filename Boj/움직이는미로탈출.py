from collections import deque
temp = []
n = 8 # Range of board

board = []
for i in range(n):
    board.append(list(input()))
       
queue = deque()
queue.append((7, 0))

dx = [0, -1, -1, -1, 0, 0, 1, 1, 1]
dy = [0, 0, -1, 1, -1, 1, 0, -1, 1]
# Stop, Up, Left_Up, Right_Up, Left, Right


def bfs():
    while queue:
        # del visited[-1]
        # visited.insert(0, [0 for _ in range(n)])
        
        visited = [[0]*n for _ in range(n)]
        for i in range(len(queue)):
            x, y = queue.popleft()
            if x == 0:
                print(1)
                return
            
            for i in range(9):
                nx = x + dx[i]
                ny = y + dy[i]
            
                if nx < 0 or nx >= n or ny < 0 or ny >= n:
                    continue
                
                if board[nx][ny] == '.' and visited[nx][ny] == 0 and board[nx-1][ny] != '#':
                    queue.append((nx, ny))
                    visited[nx][ny] = 1
        
        # 1 Level Down
        del board[-1]
        board.insert(0, ['.' for _ in range(n)])
    
    else:
        print(0)
        return
bfs()