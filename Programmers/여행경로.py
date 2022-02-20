from collections import deque

def solution(tickets):
    answer = []
    route = dict()
    for ticket in tickets:
        if ticket[0] in route:
            route[ticket[0]].append(ticket[1])
        else:
            route[ticket[0]] = [ticket[1]]
    
    for r in route:
        route[r] = sorted(route[r], reverse=True)
    
    
    temp = ["ICN"]
    
    while temp:
        dst = temp[-1]
        if dst not in route or len(route[dst]) == 0:
            answer.append(temp.pop())
        else:
            temp.append(route[dst].pop())
        
    return answer[::-1]

if __name__ == '__main__':
    # tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
    tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]] 
    answer = solution(tickets)