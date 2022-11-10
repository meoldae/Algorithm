#Baekjoon 18428
import sys
from collections import deque
input = sys.stdin.readline

def observe():
    global hallway, teachers
    queue = deque(teachers)
    
    while queue:
        x, y = queue.popleft()
        
        for r in range(y+1, n): # Right
            if hallway[x][r] == 'O':
                break
            elif hallway[x][r] == 'S':
                return True
            else:
                continue
        
        for l in range(y-1, -1, -1): # Left
            if hallway[x][l] == 'O':
                break
            elif hallway[x][l] == 'S':
                return True
            else:
                continue
        
        for u in range(x, -1, -1): # Up
            if hallway[u][y] == 'O':
                break
            elif hallway[u][y] == 'S':
                return True
            else:
                continue
        
        for d in range(x, n): # Down
            if hallway[d][y] == 'O':
                break
            elif hallway[d][y] == 'S':
                return True
            else:
                continue
    return False

def dfs(x, y, count):
    global hallway
    
    if count == 3:
        if observe():
            return
        else:
            print('YES')
            exit()
    
    for i in range(x, n):
        if i == x:
            for j in range(y, n):
                if hallway[i][j] == 'X': 
                    hallway[i][j] = 'O'
                    dfs(i, j, count+1)
                    hallway[i][j] = 'X'
        else:
            for j in range(n):
                if hallway[i][j] == 'X':
                    hallway[i][j] = 'O'
                    dfs(i, j, count+1)
                    hallway[i][j] = 'X'           
    return

if __name__ == '__main__':
    n = int(input())

    hallway = []
    teachers = []

    for i in range(n):
        temp = list(input().rstrip().split())
        hallway.append(temp)
        for j in range(n):
            if temp[j] == 'T':
                teachers.append((i, j))
    
    for i in range(n):
        for j in range(n):
            if hallway[i][j] == 'X':
                hallway[i][j] = 'O'
                dfs(i, j, 1)
                hallway[i][j] = 'X'
                
    print('NO')