# Baekjoon 16916
import sys
input = sys.stdin.readline

str = input().rstrip()
w = input().rstrip()


def checking(str, w):
    l = len(w)
    left = 0
    while left < len(str)-1:
        
        if w[0] == str[left]:
            temp_left = left+1
            
            for i in range(1, l):
                if w[i] == str[temp_left]:
                    temp_left += 1
                    
                    if temp_left >= len(str):
                        return 0
                else:
                    left = temp_left
                    break
            else:
                return 1
        else:
            left += 1
    return 0

print(checking(str, w))