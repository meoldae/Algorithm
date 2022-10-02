#Baekjoon 9663
import sys
input = sys.stdin.readline

def check(maxVal, nextQueens):
    for i in range(maxVal):
        if nextQueens[maxVal] == nextQueens[i] or abs(nextQueens[maxVal] - nextQueens[i]) == abs(maxVal-i):
            return False
    return True

def dfs(i, queens):
    global answer, n
    if i == n:
        answer += 1
        return
    else:
        for j in range(n):
            queens[i] = j
            if check(i, queens):
                dfs(i+1, queens)
        return

if __name__ == '__main__':
    n = int(input())
    answer = 0
    queens = [0]*n
    dfs(0, queens)
    
    print(answer)