package com.company;

import java.util.Scanner;

public class Human extends Player {
    public Human(final String name) {
        super(name);
    }

    @Override
    public Integer[] getMove(final TicTacToeBoard board) {
        final Integer[] move = new Integer[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Enter a valid move");
        final int input = Integer.parseInt(scanner.nextLine());
        move[0] = (input - 1) / 3;
        move[1] = (input - 1) % 3;
        return move;
    }
}
