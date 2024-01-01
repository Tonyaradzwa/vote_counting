package vote_counting_java;

import java.util.ArrayList;

/**
 * This class stores information
 * on candidates
 * 
 */
public class Candidates {
	// instance variables 
	public ArrayList<Integer> candidateNumbers; // array of numbers representing candidates
	public int numberOfVotes; // the number of votes for the candidate
	
	// constructor
	/**
	 * Initializes the values of the arraylist storing the number of votes for each candidate
	 * Each index represents a candidate. The first index (0) represents the invalid count
	 * 
	 * @param n the number of candidates participating in the election
	 */
	public Candidates(int n) {
		candidateNumbers = new ArrayList<Integer>(n);
		for (int i = 0; i <= n; i++)
			candidateNumbers.add(0);	
	}
	// useful methods
	 
	// toString method
	public String toString() {
		return "These are the candidates' votes: " + candidateNumbers;
	}
	
	// main method to test this class
	public static void main(String args[]) {
		System.out.println(new Candidates(4));
		
	}
}
