#Baekjoon 20437 
import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    min_val = 10001
    max_val = 0
    w = input().rstrip().lower()
    k = int(input())
    check = False
    for i in range(26):
        word = i+97
        if w.count(chr(word)) < k:
            continue
        else:
            check = True
            idx = [ j for j in range(len(w)) if w[j] == chr(word)]
            left = 0
            right = left + k - 1
            
            while right <= len(idx)-1:
                temp = idx[right] - idx[left] + 1
                
                min_val = min(min_val, temp)
                max_val = max(max_val, temp)
                
                left += 1
                right = left + k - 1
    if check:
        print(min_val, max_val)
    else:
        print(-1)