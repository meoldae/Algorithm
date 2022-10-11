H, W = map(int, input().split())

w = list(map(int, input().split()))

answer = 0

for i in range(1, W-1):
    left = max(w[:i])               # 현재 웅덩이의 좌측 기둥
    right = max(w[i+1:])            # 현재 웅덩이의 우측 기둥
    
    if min(left, right) > w[i]:    # 높이가 죄다 같을수도 있으므로 
        answer += (min(left, right) - w[i])    # 현재 웅덩이 깊이

print(answer)


