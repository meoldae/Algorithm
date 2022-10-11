#Baekjoon 1946
import sys, heapq
input = sys.stdin.readline

n = int(input())

for _ in range(n):
    m = int(input())
    people = []
    people_dict = dict()
    for _ in range(m):
        document, interview = map(int, input().split())
        people_dict[document] = interview
        heapq.heappush(people, document)
    
    first = people_dict[heapq.heappop(people)]
    count = 1
    for _ in range(len(people)):
        docu = heapq.heappop(people)
        if first > people_dict[docu]:
            first = people_dict[docu]
            count += 1
    print(count)