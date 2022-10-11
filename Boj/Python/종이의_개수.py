#Baekjoon 1780
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())

def dfs(src_r, src_c, N):
    flag = paper[src_r][src_c]
    for i in range(N):
        for j in range(N):
            if paper[src_r + i][src_c + j] != flag:
                next_n = N//3
                for a in range(3):
                    for b in range(3):
                        dfs(src_r+(next_n*a), src_c+(next_n*b), next_n)

                return
    
    answer[flag] += 1
    
    

paper = []
answer = defaultdict(int)
for _ in range(n):
    paper.append(list(map(int, input().split())))
    
dfs(0, 0, n)

print(answer[-1])
print(answer[0])
print(answer[1])