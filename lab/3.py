import math
n=int(input("enter the number of items:"))
print("enter list items:")
list1=[]
for i in range(n):
    ele=int(input())
    list1.append(ele)
    list1.sort()
print(list1)


val=int(input("enter the value:"))
gap=math.sqrt(len(list1))
left=0
while(list1[int(min(gap,len(list1))-1)]<val):
    left=gap
    gap=gap+math.sqrt(len(list1))
    if(left>=len(list1)):
        break
while(list1[int(left)]<val):
    left=left+1
    if(left==min(gap,len(list1))):
        break
if(list1[int(left)]==val):
    print(int(left))
