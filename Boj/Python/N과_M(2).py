#Baekjoon 15650
import sys
input = sys.stdin.readline

def dfs(start, n):
    if len(nums) == m:
        print(*nums)
    else:
        for j in range(start, n+1):
            if not visited[j]:
                nums.append(j)
                dfs(j+1, n)
                nums.remove(j)
                visited[j] = False
    return

n, m = map(int, input().split())
nums = []
visited = [False]*(n+1)
for i in range(1, n+1):
    nums.append(i)
    visited[i] = True
    dfs(i, n)
    nums.remove(i)
    visited[i] = False