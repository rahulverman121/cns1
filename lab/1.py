import sys as s


def disarium():
    print("Disarium Numbers:")
    for i in range(1, 100):
        arr = [int(num) for num in str(i)]
        sum = 0
        for j, n in enumerate(arr):
            sum += n**(j+1)
        if sum == int(i):
            print(sum)


def ceasercipher(var):
    text = var
    ceaser = " "
    for char in text:
        var = ord(char)+3
        if(text.islower() and var > ord("z")) or (text.isupper() and var > ord("Z")):
            var = var-26
        ceaser += chr(var)
    print(ceaser)


ch = int(input("Enter the choice:\n1.disarium\n2.ceasercipher\n3.exit:"))
if ch == 1:
    disarium()
elif ch == 2:
    plaintext = input("Enter the string:")
    ceasercipher(plaintext)
elif ch == 3:
    s.exit()
else:
    print("Invalid")
