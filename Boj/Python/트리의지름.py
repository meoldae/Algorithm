#Baekjoon 1967
# Root 로부터 가장 먼 Leaf 노드 선정 > 선정한 Node로 부터 가장 먼 곳까지의 거리 측정
# Tree = 양방향 그래프 / 방문처리 필요할듯 ?
import sys
from collections import defaultdict
sys.setrecursionlimit(100000)
input = sys.stdin.readline

n = int(input())
tree = defaultdict(list)

for _ in range(n-1):
    parent, child, cost = map(int, input().split())
    
    tree[parent].append([child, cost])
    tree[child].append([parent, cost])

def dfs(node, value, visited):
    global max_value
    global max_leaf
    visited[node] = 1

    if all(visited[i] == 1 for i, j in tree[node]) :
        if max_value < value: max_leaf = node
        max_value = max(max_value, value)
        
        return 
    
    for temp_child in tree[node]:
        if visited[temp_child[0]] != 1:
            dfs(temp_child[0],  temp_child[1]+value, visited)    
    return

visited = [0]*(n+1)
root = 1
max_value = 0
max_leaf = 0
dfs(root, 0, visited)

visited = [0]*(n+1)
dfs(max_leaf, 0, visited)
print(max_value)