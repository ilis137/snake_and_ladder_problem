package com.practice;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Player {
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

    public int getDieRoll() {
        return dieRoll;
    }

    public void setDieRoll(int dieRoll) {
        this.dieRoll = dieRoll;
    }

    SnakeAndLadder(Player player1) {
        this.player1 = player1;
    }

    void rollDice() {
        Random random = new Random();
        int dieRoll = random.nextInt(6)+1;
        this.setDieRoll(dieRoll);
        log.info("die rolled to: " + dieRoll);
    }

    public static void main(String[] args) {
        Player player1 = new Player();

        SnakeAndLadder game = new SnakeAndLadder(player1);
        game.player1.setPosition(0);
        log.info("initial position of player 1 is:" + game.player1.getPosition());

        game.rollDice();

    }
}
