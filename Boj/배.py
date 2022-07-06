#Baekjoon 1092
import sys
input = sys.stdin.readline

def solution(boxes, cranes):
    if boxes[0] > cranes[0]:
        print(-1)
        return

    count = 0
    while boxes:
        idx = 0
        for crane in cranes:
            while idx < len(boxes):
                if crane >= boxes[idx]:
                    del boxes[idx]
                    break
                else:
                    idx += 1        
        count += 1            
    print(count)
    return                
            
n = int(input())
cranes = list(map(int, input().split()))
cranes.sort(reverse=True)
m = int(input())
boxes = list(map(int, input().split()))
boxes.sort(reverse=True)

solution(boxes, cranes)