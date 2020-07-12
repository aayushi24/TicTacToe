package com.company;

import com.company.models.Piece;

public abstract class Player {
    private boolean isTurn;
    private String name;
    private Piece piece;

    public Player(final String name){
        this.name = name;
    }

    public boolean getIsTurn() {
        return isTurn;
    }
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }
    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(final Piece piece) {
        this.piece = piece;
    }

    public abstract Integer[] getMove(final TicTacToeBoard board);
}
