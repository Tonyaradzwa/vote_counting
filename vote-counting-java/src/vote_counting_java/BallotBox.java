package vote_counting_java;

public class BallotBox {
	// your instance variables
	public int votingPopulation;
	public int numberOfCandidates;
	
	// your constructor
	
	/**
	 * This creates a ballot box that stores all the votes
	 */
	public BallotBox(int votingPopulation) {
		
		this.votingPopulation = votingPopulation;
		while (votingPopulation > 0)
			System.out.println("Enter a vote from 1 to" + numberOfCandidates);
			votingPopulation--;
	}
	
	// other useful methods
	
	
	// toString Method
	
	// main method to test this class
}
