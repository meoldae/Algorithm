x, y, w, h = map(int, input().split())
if x > (w//2):
    distance_x = w - x
else:
    distance_x = x

if y > (h//2):
    distance_y = h - y
else:
    distance_y = y

print(min(distance_x, distance_y))