package com.sltgruppeq.tictactoe;

public class Board {
    final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        if (!isCellEmpty(x, y)) {
            throw new IllegalArgumentException("Cell is not empty");
        }
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells)
            for (char c : row)
                if (c == ' ') return false;
        return true;
    }

    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = ' ';
    }

    public void print() {
        System.out.println("┌───┬───┬───┐");
        for (int i = 0; i < 3; i++) {
            System.out.printf("│ %c │ %c │ %c │%n", cells[i][0], cells[i][1], cells[i][2]);
            if (i < 2) System.out.println("├───┼───┼───┤");
        }
        System.out.println("└───┴───┴───┘");
    }
}