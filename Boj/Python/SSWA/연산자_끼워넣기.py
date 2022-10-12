#Baekjoon 14889
#삼성 SW 역량테스트 기출 문제
import sys
input = sys.stdin.readline

def dfs(now, i):
    global minVal
    global maxVal
    global sign
    
    if i >= n:
        minVal = min(minVal, now)
        maxVal = max(maxVal, now)
        return
    
    if sign[0] > 0:
        sign[0] -= 1
        dfs(now + nums[i], i+1)
        sign[0] += 1
    
    if sign[1] > 0:
        sign[1] -= 1
        dfs(now - nums[i], i+1)
        sign[1] += 1
    
    if sign[2] > 0:
        sign[2] -= 1
        dfs(now * nums[i], i+1)
        sign[2] += 1
        
    if sign[3] > 0:
        sign[3] -= 1
        # dfs(now//nums[i], i+1) << 왜 안되는 것?
        dfs(int(now / nums[i]), i+1)
        sign[3] += 1
        
    return

if __name__ == '__main__':
    n = int(input())
    nums = list(map(int, input().split()))
    sign = list(map(int, input().split()))
    
    minVal = 1e9
    maxVal = -1e9
    
    dfs(nums[0], 1)
    print(maxVal)
    print(minVal)