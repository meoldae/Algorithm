#Baekjoon 13458
#삼성 SW 역량테스트 기출 문제
import sys
input = sys.stdin.readline

n = int(input())
candidateNum = list(map(int, input().split()))
mainProctor, subProctor = map(int, input().split())

# 총 감독은 반드시 한명씩
candidateNum = list(map(lambda x:x-mainProctor, candidateNum))

answer = n
for i in range(n):
    if candidateNum[i] > 0:
        if candidateNum[i]%subProctor:
            answer += (candidateNum[i]//subProctor)+1
        else:
            answer += (candidateNum[i]//subProctor)

print(answer)