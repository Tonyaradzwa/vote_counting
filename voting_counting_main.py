"""
Author: Tonyaradzwa Chivandire
Date Begun: Fall 2020

The goal of this project is to create a decentralized voting system that:
1) allows all voters to confirm their votes have been counted.
2) allows all voters and spectators to confirm that no votes have been duplicated


Some Queries:
1. Currently, the vote receipts do not allow for any 5 last digits to be the same
e.g you cannot have 125012 and 225012, even though both are unique.
Perhaps this is the best method in terms of security. We wouldn't want
any similar loooking votes to be suspected as duplicates.

2. We can amend the program to account for different voter populations, e.g if
we have over a million voters, then the range from which we collect numbers for 
vote receiots should have a large enough number of permutations. And, if we have 
a smaller population, perhaps big numbers are not neccessary (but they will be 
more secure)

3. A note on randomizing numbers:
We have to use a while loop to maske sure we continue to request for a 
number that hasn't been used before. This means we might have many tries
and the computer wil go on and on. But, if we we try to form a sequence,
that sequence could be cracked and people will know that the person who
voted second has this number. Maybe on a larger scale this is insignificant,
but for now, let's pretend that the voter population is small enough to identify
each other by their position in the voting queue.
"""

from random import randint, sample

num_list = [] # records list of all numbers used for vote count

def make_random_unique_number(num_list, num_digits):
    """
    Creates a unique (not been used before) and random (not sequenced) number
    :param: (list) list of numbers
    :return: (int) unique and random number
    """
    num2 = randint(10 ** (num_digits - 1), 10 ** num_digits) # e.g if num_digits is 5, the range is from 10000 to 100000.
    while num2 in num_list: # the loop will continue for as long as that number already exists in the list
        num2 = randint(10 ** (num_digits - 1), 10 ** num_digits) # in future, we should make this according to the voter population so that we don't have unneccessary numbers

    return num2 # we finally return a unique and random number

def add_to_num_list(num):
    """
    Adds a number to the list of numbers
    :param: (int)
    :return: (int) the same number we put in
    """
    num_list.append(num)
    return num # we are returning this because we want to have a return value i.e we want to keep the number

def count_votes(all_votes):
    """
    Counts votes in a list of vote receipts and returns the winner and the votes for each candidate
    :param (list):
    :return: (list) 
    """
    vote_moyo_count = 0
    vote_smith_count = 0

    for vote in all_votes: # loop through the list of votes

        if vote[0] == "1": # if a vote begins with 1, then it's a vote for moyo
            vote_moyo_count += 1
        elif vote[0] == "2": # if a vote begins with 2, then it's a vote for smith
            vote_smith_count += 1 

    print("Moyo " + str(vote_moyo_count) + " Smith " + str(vote_smith_count)) # This displays the total votes for each candidate

    # this displays the winner message
    if vote_moyo_count > vote_smith_count:
        print("Mrs Moyo wins!")
    elif vote_moyo_count < vote_smith_count:
        print("Mr Smith wins!")
    else:
        print("It's a tie!")

    return [vote_moyo_count, vote_smith_count]

def randomize_votes(receipts):
    """
    Returns a list of vote receipts but, this time, shuffled or in random order
    :param: (list) list of vote receipts
    :return: (list) randomly ordered list of vote receipts
    """
    display_list = []
    return sample(receipts, len(receipts))

def main():

    voter_population = 7 # the voter population number gives us the number of times we will be asking for input i.e the number of people voting

    the_votes = [] # this is the list that will store all the vote receipts
    invalid = "0" # a vote receipt that begins with 0 represents a void/invalid vote
    vote_moyo = "1" # a vote receipt that begins with 1 represents a vote for Moyo
    vote_smith = "2" # a vote receipt that begins with 2 represents a vote for Smith
    
    num_digits = 5 # this is the number of digits that appear after the candidate digit in a vote receipt
    num_display = 3 # this is the number of votes after which we pause and display the votes

    for i in range(1, voter_population + 1):

        user_input = input("Type the number of a candidate to vote for that candidate \nMrs Moyo: 1 \nMr Smith: 2 \n")

        vote_receipt = user_input + str(add_to_num_list((make_random_unique_number(num_list, num_digits)))) # this is a unique string that represents the user's vote. It starts witht the number of the candidate they voted for.
                                                                                            # strings are immutable so noone will be able to change that number 
                                                                                            # we want this string to be randomized but unique!
        vote_receipt_display = "This is your vote receipt: " + vote_receipt + "\n"
        print(vote_receipt_display)

        the_votes.append(vote_receipt)

        # displays all the vote receipts after every 3 votes or all the votes are in
        if i % num_display == 0 or i == voter_population: 
            print("\nThese are all the votes:\n")
            print(randomize_votes(the_votes)) # this will print the votes in random order i.e not in the order in which they voted
            
    count_votes(the_votes)


# We use this block to prevent (certain) code from being run when the module is imported. https://medium.com/python-features/understanding-if-name-main-in-python-a37a3d4ab0c3
if __name__ == "__main__":
    main() 
