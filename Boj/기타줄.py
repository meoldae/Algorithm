import sys
input = sys.stdin.readline

package = []
div = []
answer = 0
n, m = map(int, input().split())

for i in range(m):
   temp1, temp2 = map(int, input().split())
   package.append(temp1)
   div.append(temp2)
   
min_package = min(package)
min_div = min(div)

if min_package < min_div*6:
    if min_package < (n%6)*min_div:
        answer = ((n//6)*min_package) + min_package
    else:
        answer = ((n//6)*min_package) + ((n%6) * min_div)
else:
    answer = n*min_div
    
print(answer)