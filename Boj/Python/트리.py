#Baekjoon 1068
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
parents = list(map(int, input().split()))
rm = int(input())

tree = defaultdict(list)

for i in range(n):
    if parents[i] == -1 or i == rm: 
        continue
    else:
        tree[parents[i]].append(i)
   
count = 0

def dfs(root, rm):
    global count
    
    if not tree[root]:
        count += 1
        return
    
    temp = list(tree[root])
    for word in temp:
        dfs(word, rm)
    return

for i in range(len(parents)):
    if parents[i] == -1:
        if i == rm:
            break
        else:
            dfs(i, rm)
                
print(count)