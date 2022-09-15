package com.practice;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Player {
    String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int position = 0;
    private int diceCount = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getDiceCount() {
        return diceCount;
    }

    public void setDiceCount(int diceCount) {
        this.diceCount = diceCount;
    }

}

public class SnakeAndLadder {
    private static final Logger log = LogManager.getLogger(SnakeAndLadder.class);
    Player player1;
    private int dieRoll = 0;

    SnakeAndLadder(Player player1) {
        this.player1 = player1;
    }

    public int getDieRoll() {
        return dieRoll;
    }

    public void setDieRoll(int dieRoll) {
        this.dieRoll = dieRoll;
    }

    void rollDice() {
        Random random = new Random();
        int dieRoll = random.nextInt(6) + 1;
        this.setDieRoll(dieRoll);
        log.info("die rolled to: " + dieRoll);
    }

    void playGame() {
        int newPosition = 0;
        String[] gameStates = { "ladder", "snake", "no_play" };
        do {

            rollDice();
            Random random = new Random();
            int option = random.nextInt(3);
            int currentPosition = player1.getPosition();
           
            switch (gameStates[option]) {

                case "ladder":
                    newPosition = currentPosition + dieRoll;
                    player1.setPosition(newPosition);
                    log.info("player will take the ladder");
                    break;
                case "snake":
                    newPosition = currentPosition - dieRoll;
                    if (newPosition < 0)
                    newPosition = 0;
                    player1.setPosition(newPosition);
                    log.info("player was bitten by sanke");
                    break;
                case "no_play":
                    newPosition = currentPosition;
                    player1.setPosition(newPosition);
                    log.info("player chose not to move");
                    break;
                default:
                    break;

            }
            log.info("player's new position is: " + newPosition);
        } while (player1.getPosition() < 100);

    }

    public static void main(String[] args) {
        Player player1 = new Player("player 1");

        SnakeAndLadder game = new SnakeAndLadder(player1);
        game.player1.setPosition(0);
        log.info("initial position of " + game.player1.getName() + " is:" + game.player1.getPosition());

        game.playGame();
    }
}
