#Baekjoon 12934
import sys
input = sys.stdin.readline
x, y = map(int, input().split())

def countTurn(x, y):
    turn = 1
    while True:
        if turn*(turn+1) // 2 == x+y:
            return turn
        
        if turn*(turn+1) // 2 > x+y:
            return -1
        turn += 1

turn = countTurn(x, y)

count = 0
if turn == -1:
    print(-1)
else:
    for i in range(turn, 0, -1):
        if x - i >= 0:
            x -= i
            count += 1
        else:
            y -= i
    
    print(count)