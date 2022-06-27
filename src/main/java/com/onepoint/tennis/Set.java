package com.onepoint.tennis;


import com.onepoint.displayScore.ScoreInformation;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Set {
    private Player playerOne;
    private Player playerTwo;

    private Integer scoreSetPlayerOne;
    private Integer tieBreakScorePlayerOne;
    private Integer scoreSetPlayerTwo;
    private Integer tieBreakScorePlayerTwo;
    private Game game;
    private Player winnerPlayer;

    public Set(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        scoreSetPlayerOne = 0;
        tieBreakScorePlayerOne = 0;
        scoreSetPlayerTwo = 0;
        tieBreakScorePlayerTwo = 0;
        game = null;
        winnerPlayer = null;
    }

    public void startGame(ScoreInformation scoreInformation) {
        System.out.println(" Game Started");
        do {
            game = new Game(this);
            game.startGame(scoreInformation);
            gameSetChange(game.getWinnerPlayer());
            setScoreInfo(scoreInformation);
        } while (winnerPlayer == null);
    }

    private void setScoreInfo(ScoreInformation scoreInformation) {
        scoreInformation.infoSetScore(scoreSetPlayerOne, scoreSetPlayerTwo);
        if (tieBreakScorePlayerOne != 0 || tieBreakScorePlayerTwo != 0)
            scoreInformation.infoTieBreakScore(tieBreakScorePlayerOne, tieBreakScorePlayerTwo);
        if (winnerPlayer != null) scoreInformation.infoSetWinner(winnerPlayer);

    }

    private void gameSetChange(Player player) {
        Boolean playerOnePoint = player.equals(playerOne);
        Boolean playerTwoPoint = player.equals(playerTwo);
        if (scoreSetPlayerOne.equals(6) && scoreSetPlayerTwo.equals(6)) {

            tieBreakRule(player);
        } else if ((playerOnePoint && scoreSetPlayerOne.equals(5) && scoreSetPlayerTwo <= 4)
                || (playerTwoPoint && scoreSetPlayerTwo.equals(5) && scoreSetPlayerOne <= 4)) {
            setPointAdd(player);
            getSetWinner(player);
        } else if ((playerOnePoint && scoreSetPlayerOne.equals(6) && scoreSetPlayerTwo <= 5)
                || (playerTwoPoint && scoreSetPlayerTwo.equals(6) && scoreSetPlayerOne <= 5)) {
            setPointAdd(player);
            getSetWinner(player);
        } else {
            setPointAdd(player);
        }

    }

    private void tieBreakRule(Player player) {

        Boolean playerOnePoint = player.equals(playerOne);
        Boolean playerTwoPoint = player.equals(playerTwo);

        tieBreakScoreChange(player);

        if ((playerOnePoint && tieBreakScorePlayerOne >= 7 && tieBreakScorePlayerOne >= (tieBreakScorePlayerTwo + 2))
                || (playerTwoPoint && tieBreakScorePlayerTwo >= 7 && tieBreakScorePlayerTwo >= (tieBreakScorePlayerOne + 2))
        ) {
            setPointAdd(player);
            getSetWinner(player);
        }
    }

    private void tieBreakScoreChange(Player player) {
        if (player.equals(playerOne)) tieBreakScorePlayerOne++;
        else tieBreakScorePlayerTwo++;

    }

    private void getSetWinner(Player player) {
        if (player.equals(playerOne)) winnerPlayer = playerOne;
        else winnerPlayer = playerTwo;
    }

    private void setPointAdd(Player winnerPlayer) {
        if (winnerPlayer.equals(playerOne)) scoreSetPlayerOne++;
        else scoreSetPlayerTwo++;
    }


}

