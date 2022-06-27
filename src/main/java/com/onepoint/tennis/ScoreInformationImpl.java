package com.onepoint.tennis;


import com.onepoint.displayScore.ScoreInformation;

public class ScoreInformationImpl implements ScoreInformation {



	public void infoGameScore(String gameScorePlayer1, String gameScorePlayer2) {
		System.out.println("Game Score  [ " + gameScorePlayer1 + " - " + gameScorePlayer2 + " ]");
		
	}

	public void infoGameWinner(Player player) {
		System.out.println(" ************ The winner of the game is " + player.getName()+"**************");
		
	}

	public void infoSetScore(Integer setScorePlayer1, Integer setScorePlayer2) {
		System.out.println("          Set Score  [ " + setScorePlayer1 + " - " + setScorePlayer2 + " ]");

	}

	public void infoTieBreakScore(Integer tieBreakScorePlayer1, Integer tieBreakScorePlayer2) {
		System.out.println(" TieBreak Score [ " + tieBreakScorePlayer1 + " - " + tieBreakScorePlayer2 + " ]");
		
	}

	public void infoSetWinner(Player player) {
		System.out.println(" **********************************************************");
		System.out.println(" ************ The winner of the Set is  " + player.getName()+"***********");
		System.out.println(" **********************************************************");

	}

}
