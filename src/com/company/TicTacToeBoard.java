package com.company;

import com.company.models.Piece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToeBoard{
    Piece[][] ticTacToeBoard = new Piece[3][3];

    public Piece[][] getBoard() {
        return ticTacToeBoard;
    }


    public Piece getPieceAt(int x, int y) throws IndexOutOfBoundsException {
        return ticTacToeBoard[x][y];
    }

    public void place(Piece piece, int x, int y) throws IndexOutOfBoundsException {
        ticTacToeBoard[x][y] = piece;
    }

    public List<Integer[]> getAvailablePositions() {
        ArrayList<Integer[]> availablePositions = new ArrayList<>();
        for (int i = 0; i < ticTacToeBoard.length; i++) {
            for (int j = 0; j < ticTacToeBoard[i].length; j++) {
                if (ticTacToeBoard[i][j] == Piece.OPEN) {
                    availablePositions.add(new Integer[]{i, j});
                }
            }
        }
        return availablePositions;
    }

    public Piece checkWon() {
        Piece checkingPlayer;

        //check columns
        for (int i = 0; i < ticTacToeBoard.length; i++) {
            checkingPlayer = ticTacToeBoard[0][i];
            if (checkingPlayer == Piece.OPEN) {
                continue;
            }
            for (int j = 0; j < ticTacToeBoard[i].length; j++) {
                if (ticTacToeBoard[j][i] != checkingPlayer) {
                    checkingPlayer = null;
                    break;
                }
            }
            if (checkingPlayer != null) {
                return checkingPlayer;
            }
        }

        //check rows
        for (Piece[] Pieces : ticTacToeBoard) {
            checkingPlayer = Pieces[0];
            if (checkingPlayer == Piece.OPEN) {
                continue;
            }
            for (Piece Piece : Pieces) {
                if (Piece != checkingPlayer) {
                    checkingPlayer = null;
                    break;
                }
            }
            if (checkingPlayer != null) {
                return checkingPlayer;
            }
        }

        //check diagonals
        checkingPlayer = ticTacToeBoard[0][0];
        if (ticTacToeBoard[1][1] == checkingPlayer && ticTacToeBoard[2][2] == checkingPlayer && checkingPlayer != Piece.OPEN) {
            return checkingPlayer;
        }

        checkingPlayer = ticTacToeBoard[2][0];
        if (ticTacToeBoard[1][1] == checkingPlayer && ticTacToeBoard[0][2] == checkingPlayer && checkingPlayer != Piece.OPEN) {
            return checkingPlayer;
        }

        //check tie;
        for (Piece[] Pieces : ticTacToeBoard) {
            for (Piece Piece : Pieces) {
                if (Piece == Piece.OPEN) {
                    return null;
                }
            }
        }

        return Piece.OPEN;
    }

    public void clear() {
        for (Piece[] row : ticTacToeBoard) {
            Arrays.fill(row, Piece.OPEN);
        }
    }
}
