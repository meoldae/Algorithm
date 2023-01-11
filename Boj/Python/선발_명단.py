#Baekjoon 3980
import sys
input = sys.stdin.readline

t = int(input())

def dfs(count, status):
    global maxVal
    if count >= 11:
        maxVal = max(maxVal, status)
        
    for i in range(11):
        if not visited[i] and players[count][i] != 0:
            visited[i] = True
            dfs(count+1, status+players[count][i])
            visited[i] = False;
    return

for _ in range(t):
    maxVal = 0
    players = []
    for _ in range(11):
        players.append(list(map(int, input().split())))
    
    visited = [False] * 11
    dfs(0, 0)
    print(maxVal)