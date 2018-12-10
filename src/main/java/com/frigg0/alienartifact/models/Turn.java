package com.frigg0.alienartifact.models;

public class Turn {
    private int turn = 2;

    public Turn(int turn) {
        this.turn = turn;
    }

    public Turn() {
        // empty constructor on purpose
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
