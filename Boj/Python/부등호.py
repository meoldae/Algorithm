#Baekjoon 2529
import sys, copy
input = sys.stdin.readline

def dfs(lst, i):
    global sign
    global minVal, maxVal, minValS

    if i >= len(sign):
        num = int(''.join(list(map(str, lst))))
        if minVal > num:
            minVal = num
            minValS = ''.join(list(map(str, lst)))
        maxVal = max(maxVal, num)
        return
    
    for j in range(10):
        temp = copy.deepcopy(lst)
        if j in lst:
            continue
        else:
            if sign[i] == '<':
                if lst[-1] < j:
                    temp.append(j)
                    dfs(temp, i+1)
            elif sign[i] == '>':
                if lst[-1] > j:
                    temp.append(j)
                    dfs(temp, i+1)
    return

if __name__ == '__main__':
    k = int(input())
    sign = list(input().rstrip().split())
    
    maxVal = 0
    minVal = 10000000000
    minValS = ''
    
    for i in range(10):
        lst = []
        lst.append(i)
        dfs(lst, 0)
    
    print(maxVal)
    print(minValS.rstrip())