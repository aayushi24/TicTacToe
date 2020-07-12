package com.company;

import java.util.Scanner;

public class PlayTTT {
    static TicTacToeGame game;

    public static void main(String[] args) {

        initialize();

        final Scanner scanner = new Scanner(System.in);

        boolean gameOver = false;

        while (!gameOver) {
            boolean inputCorrect = false;
            Integer[] move;
            final Player currentPlayer = game.getCurrentPlayer();
            System.out.print(game.getCurrentPlayer().getName() + "'s turn");
            while (!inputCorrect) {
                try {
                    move = currentPlayer.getMove(game.getBoard());
                    if (game.isValidMove(game.getBoard(), move[0], move[1])) {
                        game.getBoard().place(game.getCurrentPlayer().getPiece(), move[0], move[1]);
                        inputCorrect = true;
                    }
                } catch (Exception e) {
                    System.out.println("Bad position input!!");
                    continue;
                }
            }

            game.printBoard();

            gameOver = isGameOver();
            if (gameOver) {
                System.out.println("Would you like to play again? Y/N");
                String input = scanner.nextLine();
                if (input.toUpperCase().equals("Y")) {
                    gameOver = false;
                    game.getBoard().clear();
                    initialize();
                } else {
                    scanner.close();
                    System.out.println("Bye! Have a nice day!!");
                    System.exit(0);
                }
            } else {
                game.switchPlayer();
            }
        }
    }


    private static void initialize() {
        System.out.println("Starting new Tic Tac Toe Game");
        game = new TicTacToeGame();
    }


    private static boolean isGameOver() {
        if (game.isWinningBoard()) {
            System.out.println(game.getCurrentPlayer().getName() + " won!");
            return true;
        } else if (game.checkIfTie()) {
            System.out.println("It's a tie!");
            return true;
        } else {
            return false;
        }

    }

}
