package com.company;

import com.company.models.Piece;

import java.util.Scanner;

public class TicTacToeGame {

    private Player human;
    private Player machine;
    private TicTacToeBoard tttBoard;
    private int numTurnsLeft;

    public TicTacToeGame() {
        tttBoard = new TicTacToeBoard();
        initializePlayers();
        initializeBoard();
        numTurnsLeft = 9;
    }

    public TicTacToeBoard getBoard() {
        return tttBoard;
    }

    public boolean isWinningBoard() {
        final Piece currentPiece = getCurrentPlayer().getPiece();
        final Piece won = tttBoard.checkWon();
        if(won== null || won != currentPiece){
            return false;
        }
        return true;
    }

    public void initializePlayers() {
        final int x = (int)(Math.random() * (10));
        System.out.println("Please enter you name");
        final Scanner sc = new Scanner(System.in);
        final String name = sc.nextLine();
        human = new Human(name);
        machine = new Computer();
        if(x%2 ==0) {
            human.setTurn(true);
            human.setPiece(Piece.X);
            machine.setTurn(false);
            machine.setPiece(Piece.O);
            System.out.println(" Your turn first!!");
        } else {
            human.setTurn(false);
            human.setPiece(Piece.O);
            machine.setTurn(true);
            machine.setPiece(Piece.X);
            System.out.println(" Computer's turn first!!");
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tttBoard.place(Piece.OPEN, i, j);
            }
        }
    }

    public Player getCurrentPlayer() {
        if (human.getIsTurn()) {
            return human;
        } else {
            return machine;
        }
    }

    public void switchPlayer() {
        if (getCurrentPlayer().getName().contains("Machine")) {
            machine.setTurn(false);
            human.setTurn(true);
        } else {
            human.setTurn(false);
            machine.setTurn(true);
        }
    }

    public boolean isValidMove(final TicTacToeBoard board,final int inputX, final int inputY) {
        if (inputX < 0 || inputX > 2 || inputY < 0 || inputX > 2) {
            System.out.println("Position is out of bounds. Try again.");
            return false;
        }

        if (!board.getPieceAt(inputX, inputY).equals(Piece.OPEN)) {
            System.out.println("There is already a piece at that position. Try again.");
            return false;
        }
        numTurnsLeft--;
        System.out.println("numTurnsLeft: " + numTurnsLeft);
        return true;
    }

    public void printBoard() {
        StringBuilder buffer = new StringBuilder();
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Piece currentPiece = tttBoard.getPieceAt(i, j);
                if (currentPiece.equals(Piece.X)) {
                    System.out.print("| X |");
                } else if (currentPiece.equals(Piece.O)) {
                    System.out.print("| O |");
                } else {
                    System.out.print("|   |");
                }
            }
            System.out.println();
        }
        System.out.println(buffer.toString());
    }

    public boolean checkIfTie() {
        return numTurnsLeft <= 0;
    }

    public void startNewGame() {
        tttBoard.clear();

    }
}
