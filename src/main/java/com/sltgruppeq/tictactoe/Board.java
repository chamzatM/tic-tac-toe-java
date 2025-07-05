package com.sltgruppeq.tictactoe;

public class Board {
    // 3×3 Feld initial leer (Space = leer)
    private final char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    /** True, wenn die Zelle (x,y) noch frei ist. */
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    /**
     * Platziert den Marker in (x,y).
     * @throws IllegalArgumentException, wenn die Zelle nicht leer ist.
     */
    public void place(int x, int y, char marker) {
        if (!isCellEmpty(x, y)) {
            throw new IllegalArgumentException("Cell is not empty");
        }
        cells[x][y] = marker;
    }

    /** Setzt das Board auf Anfangszustand (alles leer). */
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    /** Gibt das Spielfeld in der Konsole aus. */
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
