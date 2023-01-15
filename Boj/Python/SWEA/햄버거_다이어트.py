t = int(input())

def dfs(taste, calorie, start):
    global maxVal
    maxVal = max(maxVal, taste)
    for i in range(start, n):
        if not visited[i]:
            if calorie + score[i][1] <= l:
                visited[i] = 1
                dfs(taste+score[i][0], calorie+score[i][1], i)
                visited[i] = 0
    return

for tc in range(1, t+1):
    n, l = map(int, input().split())

    score = []
    for _ in range(n):
        t, k = map(int, input().split())
        if k > l:
            pass
        score.append([t, k])
    score.sort(key=lambda x:(x[0], x[1]))
    maxVal = 0
    visited = [0]*n
    for i in range(n):
        visited[i] = 1
        dfs(score[i][0], score[i][1], i)
        visited[i] = 0

    print("#{} {}".format(tc, maxVal))