#Baekjoon 2660
import sys
from collections import defaultdict
input = sys.stdin.readline

if __name__ == '__main__':
    n = int(input())
    relation = [[1e9]*n for _ in range(n)]
    
    while True:
        a, b = map(int, input().split())
        if a == -1 and b == -1:
            break
        
        relation[a-1][b-1] = 1
        relation[b-1][a-1] = 1
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                
                # j k = j i + i k  