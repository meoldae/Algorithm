#Baekjoon 14499
import sys
input = sys.stdin.readline

def setDice(c, dice):
    if c == 1:
        movedDice = [dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]]
    elif c == 2:
        movedDice = [dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]]
    elif c == 3:
        movedDice = [dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]]
    else:
        movedDice = [dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]]
        
    return movedDice

def setDiceBottom(x, y, dice):
    global board
    if board[x][y] != 0:
        dice[5] = board[x][y]
        board[x][y] = 0
    else:
        board[x][y] = dice[5]
    return dice

n, m, x, y, k = map(int, input().split())

board = []
dice = [0] * 6

for _ in range(n):
    board.append(list(map(int, input().split())))
    
instruction = list(map(int, input().split()))
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

for i in instruction:
    x += dx[i-1]
    y += dy[i-1]
    
    if x < 0 or x >= n or y < 0 or y >= m:
        x -= dx[i-1]
        y -= dy[i-1]
        continue
    dice = setDice(i, dice)
    dice = setDiceBottom(x, y, dice)
    print(dice[0])