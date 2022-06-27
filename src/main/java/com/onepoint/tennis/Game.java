package com.onepoint.tennis;


import com.onepoint.displayScore.ScoreInformation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    private Player playerOne;
    private Player playerTwo;

    private Integer scorePlayerOne = 0;
    private Integer scorePlayerTwo = 0;
    private Player winnerPlayer;
    public Game(Set set) {
        playerOne = set.getPlayerOne();
        playerTwo = set.getPlayerTwo();
        scorePlayerOne = 0;
        scorePlayerTwo = 0;
        winnerPlayer = null;
    }

    public void startGame(ScoreInformation scoreInformation) {

        do {
            Player player = getRandomPlayer(this);
            GamePointChange(player, scoreInformation);
            GameScoreinfo(scoreInformation);
        } while (winnerPlayer == null);
    }

    private void GameScoreinfo(ScoreInformation scoreInformation) {
        if (winnerPlayer == null) {
            scoreInformation.infoGameScore(getRealScore(scorePlayerOne),getRealScore(scorePlayerTwo));
        } else {
            scoreInformation.infoGameWinner(winnerPlayer);
        }
    }

    private String getRealScore(Integer Score) {

        switch (Score) {
            case 0:
                return "0";
            case 1:
                return "15";
            case 2:
                return "30";
            case 3:
                return "40";
            case 4:
                return "AD";

            default:
                throw new IllegalStateException("Unexpected value: " + Score);
        }
    }

    private Player getRandomPlayer(Game game) {

        double rand = Math.random();
        return rand <= 0.5 ? game.getPlayerOne() : game.getPlayerTwo();
    }

    private void GamePointChange(Player player, ScoreInformation scoreInformation) {
        Boolean playerOnePoint = player.equals(playerOne);
        Boolean playerTwoPoint = player.equals(playerTwo);
        if (scorePlayerOne >= 3 && scorePlayerTwo >= 3) {


            DeuceRule(player, scoreInformation);

        } else if ((playerOnePoint && scorePlayerOne.equals(3) && scorePlayerTwo < 3)
                || (playerTwoPoint && scorePlayerTwo.equals(3) && scorePlayerOne < 3)) {
            getGameWinner(player, scoreInformation);
        } else {
            gamePointAdd(player, scoreInformation);
        }
    }

    private void getGameWinner(Player player, ScoreInformation scoreInformation) {
        if (playerOne.equals(player)) {

            winnerPlayer = playerOne;
        } else {
            winnerPlayer = playerTwo;
        }
        setScorePlayerOne(0);
        setScorePlayerTwo(0);
    }


    private void gamePointAdd(Player player, ScoreInformation scoreInformation) {

        if (playerOne.equals(player)) {
            scorePlayerOne++;
        } else {
            scorePlayerTwo++;
        }

    }

    private void DeuceRule(Player player, ScoreInformation scoreInformation) {
        Boolean playerOnePoint = player.equals(playerOne);
        Boolean playerTwoPoint = player.equals(playerTwo);

        if (scorePlayerOne.equals(3) && scorePlayerTwo.equals(3)) {
            gamePointAdd(player, scoreInformation);
        } else if ((playerOnePoint && scorePlayerOne.equals(4) && scorePlayerTwo.equals(3))
                || (playerTwoPoint && scorePlayerTwo.equals(4) && scorePlayerOne.equals(3))) {
            getGameWinner(player, scoreInformation);
        } else if ((playerOnePoint && scorePlayerOne.equals(3) && scorePlayerTwo.equals(4))
                || (playerTwoPoint && scorePlayerOne.equals(4) && scorePlayerTwo.equals(3))) {
            gamePointAdd(player, scoreInformation);
            // Score  to 40 - 40
            setScorePlayerOne(3);
            setScorePlayerTwo(3);
        }

    }

}
