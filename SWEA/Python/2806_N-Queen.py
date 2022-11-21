t = int(input())

def check(i):
    for j in range(i):
        if queens[j] == queens[i] or abs(queens[i] - queens[j]) == abs(i - j):
            return False
    return True

def dfs(i, count):
    global answer
    
    if count == n:
        answer += 1
        return
    else:
        for j in range(n):
            queens[i] = j
            if check(i):
                dfs(i+1, count+1)
            queens[i] = 0
    
    return

for tc in range(1, t+1):
    n = int(input())
    
    queens = [0]*n
    answer = 0
    dfs(0, 0)
    print("#{} {}".format(tc, answer))