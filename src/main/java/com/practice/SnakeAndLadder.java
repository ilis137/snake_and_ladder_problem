package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnakeAndLadder {

    private static final Logger log = LogManager.getLogger(SnakeAndLadder.class);

    public static void main(String[] args) {
    
    }
}


class Player{
    private int position=0;
    private int diceCount=0;

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