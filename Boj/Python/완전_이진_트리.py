#Baekjoon 9934
import sys
input = sys.stdin.readline

k = int(input())
buildings = list(map(int, input().split()))

def dfs(lst, depth):
    root = len(lst)//2
    answer[depth].append(lst[root])
    
    if root >= 1:
        dfs(lst[0:root], depth+1)
        dfs(lst[root+1::], depth+1)
    return

answer = [[] for _ in range(k)]
dfs(buildings, 0)
for leafs in answer:
    print(*leafs)