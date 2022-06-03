#Baekjoon 16236
import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())

board = []
fishes = defaultdict(list)
x, y = 0, 0
shark = 2   #Start Shark's size

for i in range(n):
    temp = list(map(int, input().split()))
    
    for j in range(len(temp)):
        if 0 < temp[j] <= 6:
            fishes[temp[j]] = [i, j]    # Fishes size and location
        
    board.append(temp)
    if 9 in board:
        x = i
        y = temp.index(9)

