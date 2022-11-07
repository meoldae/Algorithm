#Baekjoon 1174
import sys
input = sys.stdin.readline

def dfs(num):
    global nums
    for i in range(11):
        if int(num[-1]) > i:
            nums.append(int(num+str(i)))
            dfs(num+str(i))
    return 
    

if __name__ == '__main__':
    nums = [i for i in range(10)]
    # n = int(input())
    for i in range(11):
        dfs(str(i))
    nums.sort()
    n = int(input())
    if n > len(nums):
        print(-1)
    else:
        print(nums[n-1])