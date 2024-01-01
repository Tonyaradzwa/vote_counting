package vote_counting_java;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.*;

/**
 * This class stores the votes made by the voters
 * The Ballot Box represents a particular region 
 * of voters e.g voters in a particular district
 * 
 */
public class BallotBox {
	
	public int votingPopulation; // total population of voters in this region
	public int numberOfCandidates = 9; // number of candidates in the election
	public String region; // name of voting region
	public int regionNumber; // the identification number of the ballot box (we need to make sure that the number is not duplicable)
	public String VOTE_FILE_DIRECTORY ="/src/test/java/vote_counting_java/voteFiles";
	public int numberOfVotes; // the total number of votes made in this region
	
	
	/**
	 * This creates a ballot box that stores voter region information 
	 * and collects all the votes
	 * 
	 * @param votingPopulation population of voters in current region
	 * @param region name of voting region
	 * @param regionNumber id number of voting region 
	 */
	public BallotBox(int votingPopulation, String region, int regionNumber) {
		
		this.votingPopulation = votingPopulation;
		this.region = region;
		this.regionNumber = regionNumber;
		
//		collectVotes(); // use this method to get votes at the console
		collectVotesTest(); // use this method to generate random votes
	}
	
	
	/**
	 * Collects the votes made by the users and stores them in files
	 * 
	 */
	public void collectVotes() {
		File fullPath = new File(System.getProperty("user.dir") + VOTE_FILE_DIRECTORY);
		File voteFile = new File(fullPath + File.separator + regionNumber + "_" + region + "_votes.txt");

		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(voteFile));
			
			// first 2 lines in the file are the region number and region name 
			output.println(regionNumber); 
			output.println(region + "\n"); 

			Scanner input = new Scanner(System.in);
			int candidateNumber = 0;
			
			// this will ask each voter to enter a vote
			for (int i = 0; i < votingPopulation; i++) {
				System.out.println("For admin: enter a non-numeric character to close ballot ");
				System.out.println("Enter the number of your candidate: ");
				
				
				try {
					candidateNumber = input.nextInt();
	
					// this automatically adds the vote receipt to the list of votes
					output.println(new Vote(candidateNumber)); 	
					numberOfVotes = i + 1; // the total number of votes made in this region
					
				// if a non-numeric character is entered by the admin, the ballot closes
				} catch (InputMismatchException e) {
					break;
				}
			}
			output.close();
			System.out.println("Ballot Box closed");
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Creates random votes, collect them, and stores them in files
	 * TODO send this over to the test class
	 */
	public void collectVotesTest() {
		File fullPath = new File(System.getProperty("user.dir") + VOTE_FILE_DIRECTORY);
		File voteFile = new File(fullPath + File.separator + regionNumber + "_" + region + "_votes.txt");

		try {
			PrintWriter output = new PrintWriter(new FileOutputStream(voteFile));
			
			// first 2 lines in the file are the region number and region name 
			output.println(regionNumber); 
			output.println(region + "\n"); 

			Random randInt = new Random();
			 
			
			// this will ask each voter to enter a vote
			for (int i = 0; i < votingPopulation; i++) {

				try {
	
					// this automatically adds the vote receipt to the list of votes
					output.println(new Vote(randInt.nextInt(numberOfCandidates + 1))); 	// generates a random number from 0 to numberOfCandidates 
					numberOfVotes = i + 1; // the total number of votes made in this region
					
				// if a non-numeric character is entered by the admin, the ballot closes
				} catch (InputMismatchException e) {
					break;
				}
			}
			output.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Prints out the number of votes made so far in the region.
	 */
	public String toString() {
		
		// return the number of votes made 
		return "Total number of votes in region: " + numberOfVotes + "\nTotal number of votes: " + Vote.voteReceipts.size();
	}
	
	// main method to test this class
	public static void main(String args[]) {
		
		// Note: use smaller voting population number when doing a demo on the console
		System.out.println(new BallotBox(20, "Area1", 1));
		System.out.println("These are the vote receipts: " + Vote.voteReceipts);
		System.out.println(new BallotBox(10, "Area2", 2));
		System.out.println("These are the vote receipts: " + Vote.voteReceipts);
	}
}
