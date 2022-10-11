#Baekjoon 2606
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
m = int(input())

network = defaultdict(set)

for _ in range(m):
    src, dst = map(int, input().split())
    network[src].add(dst)
    network[dst].add(src)

computers = [0 for _ in range(n)]

def dfs(node):
    global computers
    computers[node-1] = 1

    temp = network[node]
    
    for pc in temp:
        if computers[pc-1] == 0:
            dfs(pc)
    return

dfs(1)
print(computers.count(1)-1)