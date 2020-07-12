package com.company.util;

import com.company.TicTacToeBoard;
import com.company.models.Piece;

public class MoveOptimizer {

    public Integer[] getBestMove(final TicTacToeBoard board, final Piece ai) {
        Integer[] bestMove = null;
        final Piece human;
        if(ai == Piece.O) {
            human = Piece.X;
        } else {
            human = Piece.O;
        }
        int bestScore = -100;
        for (Integer[] position : board.getAvailablePositions()) {
            board.place(ai, position[0], position[1]);
            int score = minimax(board, ai, human);
            board.place(Piece.OPEN, position[0], position[1]);
            if (score > bestScore) {
                bestScore = score;
                bestMove = position;
            }
        }
        return bestMove;
    }

    public static int minimax (final TicTacToeBoard board, final Piece ai, final Piece human) {
        Piece winner = board.checkWon();
        int score;
        if (winner != null) {
            if (winner == ai) {
                score = 1;
                return score;
            } else if (winner == Piece.OPEN) {
                score = 0;
                return score;
            } else {
                score = -1;
                return score;
            }
        }

        int aiCount = 0;
        int humanCount = 0;

        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard()[i].length; j++) {
                if (board.getBoard()[i][j] == ai) {
                    aiCount++;
                } else if (board.getBoard()[i][j] == human) {
                    humanCount++;
                }
            }
        }

        int bestScore;
        if (humanCount > aiCount) {
            bestScore = -1;
        } else {
            bestScore = 1;
        }

        for (Integer[] position : board.getAvailablePositions()) {
            board.place(humanCount > aiCount ? ai : human, position[0], position[1]);
            int currentScore = minimax(board, ai, human);
            board.place(Piece.OPEN, position[0], position[1]);
            if (humanCount > aiCount ? currentScore > bestScore : currentScore < bestScore) {
                bestScore = currentScore;
            }
        }
        return bestScore;
    }
}
