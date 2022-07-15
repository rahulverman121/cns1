import re
# Function to Find all the patterns of "1(0+)1" in a given string
def check_uc_lc_pattern(user_input):
    # regex
    pattern = re.compile("[A-Z]+[a-z]+$")

    # searching pattern
    if pattern.search(user_input):
        print("String pattern match success \n")
    else:
        print("String fails the pattern \n")

def count_pattern(user_input):
    # search regex '10+1' in original string search() function return first occurrence
    # of regex '10+1' otherwise None '10+1' means sub-string starting and ending with 1
    # and at least 1 or more zeros in between
    count = 0
    pattern = re.compile("10+1")
    substr = pattern.search(user_input)

    # search for regex in original string until we are done with complete string
    while substr != None:
        # if we find any occurrence then increase count by 1
        count = count + 1

        # find next occurrence just after previous sub-string for first occurrence of the pattern
        user_input = user_input[(substr.end() - 1) :]
        substr = pattern.search(user_input)
    print(f"The number of times the pattern appears in the string is {count} \n")

def z_followed_by_o(user_input):
    # Regex \w * zo+\w * will match text that contains 'z', followed by one or more 'o'
    pattern = re.compile("zo+\w*")

    # The findall() method returns all matching strings of the regex pattern
    match_object = pattern.findall(user_input)

    # If length of match_object is not equal to zero then it contains matched string
    if len(match_object) != 0:
        print("String pattern match success \n")
    else:
        print("No match \n")

def menu():
    while True:
        print("1 --> Identify a word with a sequence of one upper case letter followed by lower case letters")
        print("2 --> Find all the patterns of '1(0+)1' in a given string")
        print("3 --> Match a word containing 'z' followed by one or more o's")
        print("4 --> Exit the program")
        choice = int(input("Enter a number to perform any of the operation: "))
        print("\n")
        if choice == 1:
            user_input = input(
                "Enter a string with a sequence of Upper and Lower case letters: "
            )
            print("\n")
            check_uc_lc_pattern(user_input)
        elif choice == 2:
            user_input = input("Enter a string in the form of 1(0+)1 pattern: ")
            print("\n")
            count_pattern(user_input)
        elif choice == 3:
            user_input = input("Enter a string: ")
            print("\n")
            z_followed_by_o(user_input)
        else:
            break

# Main
if __name__ == "__main__":
    menu()
