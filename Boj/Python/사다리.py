#Baekjoon 2022
import sys
input = sys.stdin.readline

x, y, c = map(float, input().split())

left = 0
right = min(x, y)
answer = 0.0

while right - left > 0.000001:
    middle = (right+left)/2.0
    
    # 닮음비 이용한 방정식
    cx = (x**2 - middle**2)**0.5
    cy = (y**2 - middle**2)**0.5
    
    if ((cx*cy)/(cx+cy)) >= c:
        answer = middle
        left = middle
    else:
        right = middle

print("%.3f" %answer)