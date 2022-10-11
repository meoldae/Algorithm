#Baekjoon 1697
import sys
from collections import deque
input = sys.stdin.readline

def bfs():
    n, k = map(int, input().split())
    
    if n == k:
        print(0)
        return
    
    queue = deque()
    queue.append([n, 0])
    visit = [0]*100001
    visit[n] = 1

    d = [-1, +1, 2]

    while queue:
        node, count = queue.popleft()

        for i in range(3):
            if i == 2: n_node = node * d[i]
            else: n_node = node + d[i]
            
            if n_node < 0 or n_node >= 100001:
                continue
            
            if n_node == k:
                print(count+1)
                return
            
            if visit[n_node] == 0:
                queue.append([n_node, count+1])
                visit[n_node] = 1

bfs()