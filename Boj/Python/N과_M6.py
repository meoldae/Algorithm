#Baekjoon 15655
import sys
input = sys.stdin.readline

def backTracking(lst:list):
    global nums
    if len(lst) == m:
        print(*lst)
        return
    
    for num in nums:
        if (num not in lst) and num > lst[-1] :
            lst.append(num)
            backTracking(lst)
            lst.remove(num)
    return

n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()
lst = []
for num in nums:
    lst.append(num)
    backTracking(lst)
    lst.remove(num)