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
        route[r] = sorted(route[r])
    
    queue = deque()
    
        
    return answer

if __name__ == '__main__':
    # tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
    tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]] 
    answer = solution(tickets)