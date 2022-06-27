package com.onepoint.displayScore;

import com.onepoint.tennis.Player;

public interface ScoreInformation {

    void infoGameScore(String gameScorePlayer1, String gameScorePlayer2);

    void infoGameWinner(Player player);

    void infoSetScore(Integer setScorePlayer1, Integer setScorePlayer2);

    void infoTieBreakScore(Integer tieBreakScorePlayer1, Integer tieBreakScorePlayer2);

    void infoSetWinner(Player player);

}
