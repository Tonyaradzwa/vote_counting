package vote_counting_java;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a vote made by a voter
 */
public class Vote {

	public int votingPopulation;  
	public final static int NUMBER_OF_CANDIDATES = 9;
	public final static Candidates CANDS = new Candidates(NUMBER_OF_CANDIDATES);
	
	public boolean isValid;
	
	private String voteReceipt;
	
	private static ArrayList<String> numberList = new ArrayList<String>(); // contains the numbers to be used for the vote receipts
	public static ArrayList<String> voteReceipts = new ArrayList<String>(); // the vote receipts in string form
	
	private int candidateNumber; // is made private so that no-one can access it
	
	// constructor
	/**
	 * This creates a vote object 
	 * 
	 * @param candidateNumber the candidate's number
	 */
	public Vote(int candidateNumber) {
		// if input is invalid (not within the range) then default to zero always
		if (candidateNumber < 1|| candidateNumber > NUMBER_OF_CANDIDATES) {
			this.candidateNumber = 0;
			isValid = false;
			
		// otherwise proceed with assigning to a candidate
		} else {
			this.candidateNumber = candidateNumber;	
			isValid = true;
		}
		
		createVoteReceipt();
		
		incrementNumberOfVotes();
		
		 
	}

	/**
	 * Generates a unique and random number within a given range.
     *
     * @return 3 digit number in String form 
	 */
	public static String createUniqueRandomNumber() {
		Random randInt = new Random();
		int randNum = 100 + randInt.nextInt(1000 - 100);
		
		// continues to search for a number that has not been used before
		// to avoid want any duplicate strings
		while (numberList.contains(String.valueOf(randNum))) {
			randNum = 100 + randInt.nextInt(1000 - 100);
		}
		
		numberList.add(String.valueOf(randNum));
		return String.valueOf(randNum);
	}
	
	
	/**
	 * This method creates a vote receipt corresponding
	 * to the current vote by combining the candidate number
	 * with a unique and random 3 digit number.
	 * 
	 * @return 4 digit number in String form with first digit 
	 * 			representing the candidate number
	 */
	public String createVoteReceipt() {
		voteReceipt = String.valueOf(candidateNumber) + String.valueOf(createUniqueRandomNumber());
		
		voteReceipts.add(voteReceipt);
		return voteReceipt;
	}
	
	
	private void incrementNumberOfVotes() {
		// increments the value at the index number of the candidate
		CANDS.candidateNumbers.set(candidateNumber, CANDS.candidateNumbers.get(candidateNumber) + 1);
	}
	
	/**
	 * This method reports if a vote is valid
	 * 
	 * @return true if the vote is valid and false otherwise
	 * 
	 */
	public boolean isValidVote() {
		return isValid;
	}
	
	
	/**
	 * This method returns the vote receipt
	 * 
	 * @return 4 digit number in String form with first digit 
	 * 			representing the candidate number
	 */
	public String toString() {
		return voteReceipt;
	}
	
	// main method to test this class
	/**
	 * Creates new votes, prints out their corresponding 
	 * vote receipts, their validity and the list containing
	 * them all
	 * 
	 */
	public static void main(String args[]) {
		
		// testing valid votes
		Vote newVote = new Vote(1);
		Vote newVote1 = new Vote(5);
		// receipts begin with candidate number
		System.out.println(newVote + " " + "isValid: " + newVote.isValidVote());
		System.out.println(newVote1 + " " + "isValid: " + newVote1.isValidVote());
		
		
		// testing voided votes 
		Vote newVote2 = new Vote(0); 
		Vote newVote3 = new Vote(10); 
		// receipts begin with 0
		System.out.println(newVote2 + " " + "isValid: " + newVote2.isValidVote());
		System.out.println(newVote3 + " " + "isValid: " + newVote3.isValidVote());
		
		
		// testing that votes are added up
		new Vote(1); new Vote(2); new Vote(9); new Vote(1); new Vote(1); new Vote(9);
		new Vote(9); new Vote(1); new Vote(1); new Vote(3);
		// should print [2, 6, 1, 1, 0, 1, 0, 0, 0, 3]
		System.out.println(CANDS);
		
		// testing that all vote receipts are added to the list
		System.out.println("These are the votes: " + voteReceipts);
		
	}

}
