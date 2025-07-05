package com.sltgruppeq.tictactoe;

public class Board {
    // Das 3×3-Spielfeld
    // package-private, damit TicTacToe.hasWinner() direkt darauf zugreifen kann
    final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    /** Setzt alle Zellen auf leer (' '). */
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /** Gibt true zurück, wenn die Zelle (x,y) noch leer ist. */
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    /**
     * Platziert den Marker in Zelle (x,y).
     * @throws IllegalArgumentException, wenn die Zelle nicht leer ist.
     */
    public void place(int x, int y, char marker) {
        if (!isCellEmpty(x, y)) {
            throw new IllegalArgumentException("Cell is not empty");
        }
        cells[x][y] = marker;
    }

    /** Gibt true zurück, wenn alle Zellen belegt sind. */
    public boolean isFull() {
        for (char[] row : cells) {
            for (char c : row) {
                if (c == ' ') return false;
            }
        }
        return true;
    }

    /** Druckt das Spielfeld mit Box-Zeichen in der Konsole. */
    public void print() {
        System.out.println("┌───┬───┬───┐");
        for (int i = 0; i < 3; i++) {
            System.out.printf("│ %c │ %c │ %c │%n",
                    cells[i][0], cells[i][1], cells[i][2]);
            if (i < 2) System.out.println("├───┼───┼───┤");
        }
        System.out.println("└───┴───┴───┘");
    }
}
