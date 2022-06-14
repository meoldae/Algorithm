#Baekjoon 21942
import sys
from datetime import datetime
from collections import defaultdict
input = sys.stdin.readline

N, L, F = input().split()
N = int(N)
F = int(F)

L1, L2 = L.split('/')
L1 = int(L1) + 1
L1 = str(L1)

temp = datetime.strptime(L1+"/"+L2, "%j/%H:%M")
    
origin = datetime(1900, 1, 1)
due = temp - origin

infos = defaultdict(dict)
answer = defaultdict(int)

for _ in range(N):
    day, time, device, id = input().split()

    info = datetime.strptime(day+" "+time, "%Y-%m-%d %H:%M")
    
    if device in infos[id]:
        term = info - infos[id][device]       
        
        diff = ((term.days - due.days) * 1440) + ((term.seconds - due.seconds)//60)
        
        if diff > 0:
            answer[id] += diff * F
                                
        del infos[id][device]
                
    else:
        infos[id][device] = info

if len(answer) == 0:
    print(-1)
else:
    for key in sorted(list(answer.keys())):
        print(key, answer[key])