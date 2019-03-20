package com.frigg0.alienartifact.models.utils;

public class Turn {
    /* Declaration */
    private int turn = 2;

    /* Constructors */
    public Turn(int turn) {
        this.turn = turn;
    }

    public Turn() {
        // empty constructor on purpose
    }

    /* Getter and setter */
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
