#Baekjoon 1337
import sys
input = sys.stdin.readline

n = int(input())
max_val, p_count, m_count = 1, 1, 1
answer = [int(input()) for _ in range(n)]

for num in answer:
    for j in range(1, 5):
        if (num - j) in answer:
            m_count += 1
                
        if (num + j) in answer:
            p_count += 1

    max_val = max(max_val, m_count, p_count)
    m_count, p_count = 1, 1

print(5-max_val)