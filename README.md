# Vote Counting

The goal of this project is to create a decentralized vote counting system that prevents the rigging of votes during an election. This voting system:
1. Prevents duplication of votes.
2. Prevents creation of imaginary votes (i.e. votes that have not been made by any real voter)
3. Ensures all valid votes are counted.
4. Allows all parties involved in the election (the voters, candidates. etc.) to verify for themselves that the 3 conditions stated above are met.

## How does the voting system work?
Take an example, John, a registered voter.
1. John makes a vote. 
2. He is assigned a unique string of digits representing the vote he made called a “vote receipt” and is known only to him.
3. His vote receipt is stored along with all other voters' vote receipts.
4. After a large number of votes have been made, all the vote receipts are displayed for the public.
5. Given the public access to all the vote receipts, John has the ability to: 
    1. Look up his vote receipt to see if it was counted (3) 
    2. Find out if there are any other vote receipts that match his to ensure his vote has not been duplicated (1)
6. Once John does this, he can now **verify** his vote.
7. Once the vote is verified, the public can see that the status of his vote receipt has changed to “verified” and can be counted a real vote.
8. This is done by all the voters such that any vote that remains unverified is considered to be an imaginary vote and will not be counted. (3)

## Implementation

So far, steps 1 to 4 have been implemented in Java (see the [Python file](https://github.com/Tonyaradzwa/vote_counting/blob/main/voting_counting_main.py) for a simple implementation) in three classes: 
### `Vote` 
A class that represents a vote made by a voter

### `BallotBox` 
A class that stores the votes made by the voters The Ballot Box represents a particular region of voters e.g voters in a particular district

### `Candidates` 
A class that stores information on the candidates of the election

### Prerequisites

- Java IDE e.g. [Eclipse](https://www.eclipse.org/downloads/packages/)

### Installing and Running the Program

Download the files onto your computer. 
For a random sample of votes, simply run the BallotBox.java file
For demonstration of the voting process at the console, go to line 40 and comment (out) accordingly.

  // collectVotes(); // use this method to get votes at the console	
	collectVotesTest(); // use this method to generate random votes

Reduce the sample number of voters in the main method by changing the first parameter of the Ballot

    System.out.println(new BallotBox(300, "Area1", 1));
    
Run the file again. 
This is what the output should look like:

    For admin: enter a non-numeric character to close ballot 
    Enter the number of your candidate: 

Enter the number of the candidate that you are voting for. Repeat.
When the total number of votes reaches the voting population for that region, the ballot box will close and you will receive a report like this

    Ballot Box closed
    Total number of votes in region: 2
    Total number of votes: 2
    These are the vote receipts: [1289, 2411]
    
Enter the votes for the next region

    Ballot Box closed
    Total number of votes in region: 3
    Total number of votes: 5
    These are the vote receipts: [1289, 2411, 3976, 4323, 5617]

The regional report on votes is still available and the total number of votes is updated. Notice the list of vote receipts contains receipts from all regions.

## Author

  - **Tonyaradzwa Chivandire**
