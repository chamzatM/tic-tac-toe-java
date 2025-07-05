package com.sltgruppeq.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    private Player currentPlayer = player1;
    private final Board board = new Board();

    public TicTacToe() { }

    public void start() {
        Scanner sc = new Scanner(System.in);
        board.clear();

        while (true) {
            // US-02: Aktuellen Spielstand anzeigen
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            // Input abfragen
            System.out.print("row (0-2): ");
            int x = sc.nextInt();
            System.out.print("column (0-2): ");
            int y = sc.nextInt();

            // US-01: Move placement with validation
            try {
                board.place(x, y, currentPlayer.getMarker());
            } catch (IllegalArgumentException e) {
                System.out.println("Ungültiger Zug – Feld bereits belegt! Bitte erneut versuchen.");
                continue;
            }

            // US-03: Auf Sieg prüfen
            if (hasWinner()) {
                board.print();
                System.out.println("Spielende: Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                return;
            }

            // US-03: Auf Unentschieden prüfen
            if (board.isFull()) {
                board.print();
                System.out.println("Unentschieden!");
                return;
            }

            // Spieler wechseln
            switchCurrentPlayer();
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char[][] c = board.cells;  // package‐private Zugriff möglich

        // Reihen prüfen
        for (int i = 0; i < 3; i++)
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) return true;
        // Spalten prüfen
        for (int j = 0; j < 3; j++)
            if (c[0][j] == m && c[1][j] == m && c[2][j] == m) return true;
        // Diagonalen prüfen
        if (c[0][0] == m && c[1][1] == m && c[2][2] == m) return true;
        if (c[0][2] == m && c[1][1] == m && c[2][0] == m) return true;

        return false;
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}
