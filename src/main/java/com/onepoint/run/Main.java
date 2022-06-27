package com.onepoint.run;

import com.onepoint.displayScore.ScoreInformation;
import com.onepoint.tennis.Player;
import com.onepoint.tennis.ScoreInformationImpl;
import com.onepoint.tennis.Set;


public class Main {

    public static void main(String[] args) {
        Player playerOne = new Player("khaled");
        Player playerTwo = new Player("One Point");
        ScoreInformation scoreInformation = new ScoreInformationImpl();
        Set set = new Set(playerOne, playerTwo);
        set.startGame(scoreInformation);
    }


}
