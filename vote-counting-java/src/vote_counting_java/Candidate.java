package vote_counting_java;

/**
 * This class stores information
 * on a candidate
 * 
 */
public class Candidate {
	// instance variables 
	public String name; // name of the candidate
	public int number; // number representing the candidate
	public int numberOfVotes; // the number of votes for the candidate
	
	// constructor
	public Candidate(String name, int number) {
		this.name = name;
		this.number = number;
		this.numberOfVotes = 0;
	}
	// useful methods
	 
	// toString method
	public String toString() {
		return name + " #" + number + " : " + numberOfVotes;
	}
	
	// main method to test this class
	public static void main(String args[]) {
		System.out.println(new Candidate("Moyo", 1));
		System.out.println(new Candidate("Smith", 2));
	}
}
