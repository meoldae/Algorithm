#Baekjoon 1182
import sys
input = sys.stdin.readline

def dfs(i, now):
    global s
    global lst
    global answer
    
    if i >= n:
        return
    
    plus_now = now + lst[i]
    
    if plus_now == s:
        answer += 1
    
    dfs(i+1, now)
    dfs(i+1, plus_now)
    
    return

if __name__ == '__main__':
    n, s = map(int, input().split())
    lst = list(map(int, input().split()))

    answer = 0
    dfs(0, 0)
    
    print(answer)