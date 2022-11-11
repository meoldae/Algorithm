#Baekjoon 2660
import sys
input = sys.stdin.readline

if __name__ == '__main__':
    n = int(input())
    relation = [[1e9]*n for _ in range(n)]
    
    while True:
        a, b = map(int, input().split())
        if a == -1 and b == -1:
            break
        
        relation[a-1][b-1] = 1
        relation[b-1][a-1] = 1
    
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if j == k:
                    relation[j][k] = 0
                    continue
                else:
                    if relation[j][k] > relation[j][i] + relation[i][k]:
                        relation[j][k] = relation[j][i] + relation[i][k]

    answer = []
    for s in relation:
        answer.append(max(s))
    
    print(min(answer), answer.count(min(answer)))
    for idx in range(n):
        if answer[idx] == min(answer):
            print(idx+1, end=" ")