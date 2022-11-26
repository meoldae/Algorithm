#Baekjoon 2580
import sys
from collections import deque
input = sys.stdin.readline

def check(x, y, num):
    for i in range(10):
        if sudoku[x][i-1] == num or sudoku[i-1][y] == num:
            return False
    return True

def checkSquare(x, y, num):
    srcX = x//3 * 3
    srcY = y//3 * 3
    
    for i in range(3):
        for j in range(3):
            if sudoku[srcX+i][srcY+j] == num:
                return False
    return True

def dfs():
    global target, sudoku
    
    if not target:
        for line in sudoku:
            print(*line)
        exit()
    else:
        x, y = target.popleft()
        for num in range(1, 10):
            if check(x, y, num) and checkSquare(x, y, num):
                sudoku[x][y] = num
                dfs()
                sudoku[x][y] = 0
                
        target.appendleft([x, y])    
    return 

sudoku = []
target = deque()
for i in range(9):
    temp = list(map(int, input().split()))
    for j in range(9):
        if temp[j] == 0:
            target.append([i, j])
    sudoku.append(temp)
dfs()