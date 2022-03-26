#Baekjoon 1068
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
parents = list(map(int, input().split()))
rm = int(input())

tree = defaultdict(list)

for i in range(n):
    if parents[i] != -1 and i != rm:
        tree[parents[i]].append(i)

count = 0

def dfs(root):
    global count
    temp = list(tree[root])
    for word in temp:
        if word not in tree:
            count += 1
        else:
            dfs(word)
    return


del parents[rm]

for i in range(len(parents)):
    if parents[i] == -1:
        if tree[i] == []:
            count += 1 
        else:
            dfs(i)
                
print(count)