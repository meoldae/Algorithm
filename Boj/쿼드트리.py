#Baekjoon 1992
import sys
input = sys.stdin.readline

def dfs(src_r, src_c, N):
    flag = image[src_r][src_c]
    for r in range(src_r, src_r+N):
        for c in range(src_c, src_c+N):
            if image[r][c] != flag:
                next_n = N//2
                print("(", end="")
                dfs(src_r, src_c, next_n)               # Left Top
                dfs(src_r, src_c+next_n, next_n)        # Right Top
                dfs(src_r+next_n, src_c, next_n)        # Left Bottom
                dfs(src_r+next_n, src_c+next_n, next_n) # Rigth Bottom
                print(")", end="")
                
                # for a in range(2):
                #     for b in range(2):
                #         dfs(src_r+(a*next_n), src_c+(b*next_n), next_n)
                # 이중반복문 사용으로 코드 축약 가능
                
                return
    else:
        print(flag, end="")
    
    return

n = int(input())

image = []
for _ in range(n):
    image.append(list(map(int, list(str(input().rstrip())))))
    
dfs(0, 0, n)