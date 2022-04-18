#Baekjoon 17140
import sys
input = sys.stdin.readline

r, c, k = map(int, input().rstrip().split())

board = []
for _ in range(3):
    board.append(list(map(int, input().rstrip().split())))
    
print(board)