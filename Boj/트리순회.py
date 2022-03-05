import sys
input = sys.stdin.readline

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None
        
# 전위 Root > Left > Right
def preorder(node):
    print(node.data, end='')
    if node.left != '.':
        preorder(node.left)
    if node.right != '.':
        preorder(node.right)

# 후위 Left > Right > Root
def postorder(node):
    if node.left != '.':
        postorder(node.left)
    if node.right != '.':
        postorder(node.right)
    print(node.data, end='')

# 중위 Left > Root > Right
def inorder(node):
    if node.left != '.':
        inorder(node.left)
    print(node.data, end='')
    if node.right != '.':
        inorder(node.right)

n = int(input())
tree = []
for i in range(n):
    temp = input().split()
    
    node = Node(temp[0])
    node.left = temp[1]
    node.right = temp[2]
    
    tree.append(node)
    
for i in range(n):
    for j in range(n):
        if tree[i].data == tree[j].left:
            tree[j].left = tree[i]
        elif tree[i].data == tree[j].right:
            tree[j].right = tree[i]

root = tree[0]
preorder(root)
print()
inorder(root)
print()
postorder(root)