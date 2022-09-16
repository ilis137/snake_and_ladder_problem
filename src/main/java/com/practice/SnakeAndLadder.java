package com.practice;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Player {
    private String name;
    private int position = 0;
    private int diceCount = 0;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    Player player2;
    private int dieRoll = 0;

    SnakeAndLadder(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getDieRoll() {
        return dieRoll;
    }

    public void setDieRoll(int dieRoll) {
        this.dieRoll = dieRoll;
    }

    void rollDice(Player player) {
        Random random = new Random();
        int dieRoll = random.nextInt(6) + 1;
        this.setDieRoll(dieRoll);
        int diceCount = player.getDiceCount();
        player.setDiceCount(++diceCount);
        log.info(player.getName() + "'s dice rolled to: " + dieRoll);
    }

  
    void playOption(Player player) {
        int currentPosition = player.getPosition();
        int newPosition = 0;
        String[] gameStates = { "ladder", "snake", "no_play" };
        Random random = new Random();
        int option = random.nextInt(3);
        
        switch (gameStates[option]) {
            case "ladder":
                newPosition = currentPosition + dieRoll;
                if (newPosition > 100)
                    newPosition = currentPosition;
                player.setPosition(newPosition);
                log.info(player.getName() + " will take the ladder");
                log.info(player.getName() + " new position is: " + newPosition);
                log.info(player.getName() + " Got ladder so playing again");
                rollDice(player);           
                playOption(player);
                break;
            case "snake":
                newPosition = currentPosition - dieRoll;
                if (newPosition < 0)
                    newPosition = 0;
                player.setPosition(newPosition);
                log.info(player.getName() + " was bitten by snake");
                break;
            case "no_play":
                newPosition = currentPosition;
                player.setPosition(newPosition);
                log.info(player.getName() + " chose not to move");
                break;
            default:
                break;

        }

    }

    void playGame() {

        Player player = null;
        do {
            if (player != null) {
                player = (player == player1) ? player2 : player1;
            } else {
                player = player1;
            }
            rollDice(player);       
            playOption(player);

            log.info(player.getName() + " new position is: " + player.getPosition());

        } while (player1.getPosition() < 100 && player2.getPosition() < 100);

        log.info(player.getName() + " has won the game");
        log.info(player.getName() + " rolled dice " + player.getDiceCount() + " times to win the game");
    }

    public static void main(String[] args) {
        Player player1 = new Player("player 1");
        Player player2 = new Player("player 2");
        SnakeAndLadder game = new SnakeAndLadder(player1, player2);
        game.player1.setPosition(0);
        log.info("initial position of " + game.player1.getName() + " is:" + game.player1.getPosition());
        game.player2.setPosition(0);
        log.info("initial position of " + game.player2.getName() + " is:" + game.player2.getPosition());

        game.playGame();
    }
}
