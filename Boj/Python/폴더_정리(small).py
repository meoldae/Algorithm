#Baekjoon 22860
import sys
from collections import defaultdict
sys.setrecursionlimit(100000)

def search(directoryName):
    global count, kinds
    for name, flag in directory[directoryName]:
        if flag == '1':
            search(name)
        else:
            kinds.add(name)
            count += 1
            
    return
    
input = sys.stdin.readline

n, m = map(int, input().split())

directory = defaultdict(list)
for _ in range(n+m):
    parent, child, flag = input().split()
    
    directory[parent].append([child, flag])

t = int(input())
for _ in range(t):
    parsing = list(input().rstrip().split('/'))
    kinds = set()
    count = 0
    
    search(parsing[-1])
    print(len(kinds), count)