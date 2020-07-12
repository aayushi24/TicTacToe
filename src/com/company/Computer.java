package com.company;

import com.company.util.MoveOptimizer;

public class Computer extends Player {

    private MoveOptimizer optimizer;

    public Computer() {
        super("Machine");
        optimizer = new MoveOptimizer();
    }

    @Override
    public Integer[] getMove(final TicTacToeBoard board) {
        return optimizer.getBestMove(board, getPiece());
    }
}
