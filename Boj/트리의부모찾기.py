#Baekjoon 11725
import sys
from collections import defaultdict
input = sys.stdin.readline
global answer
answer = dict()

def dfs(node, dict):
    
    for next in dict[node]:
        if visited[next] == 0:
            visited[next] = 1
            answer[next] = node
            dfs(next, dict)
    return    

n = int(input())
tree = defaultdict(list)

global visited
visited = [0]*(n+1)

for _ in range(n-1):
    a, b = map(int, input().split())
    
    tree[a].append(b)
    tree[b].append(a)

dfs(1, tree)
for key in range(2, n+1):
    print(answer[key])