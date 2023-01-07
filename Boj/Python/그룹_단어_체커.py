#Baekjoon 1316
n = int(input())
answer = 0
for _ in range(n):
    s = input().rstrip()
    visited = [False] * 27
    visited[ord(s[0])-97] = True
    for i in range(1, len(s)):
        if s[i] == s[i-1]:
            continue
        else:
            if visited[ord(s[i])-97] == True:
                break
            else:
                visited[ord(s[i])-97] = True
    else:
        answer += 1

print(answer)