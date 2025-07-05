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
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());
            System.out.print("row (0-2): ");
            int x = sc.nextInt();
            System.out.print("column (0-2): ");
            int y = sc.nextInt();

            // --- US-01: Move machen ---
            try {
                board.place(x, y, currentPlayer.getMarker());
            } catch (IllegalArgumentException e) {
                System.out.println("Ungültiger Zug – Feld bereits belegt! Bitte erneut versuchen.");
                continue;  // erneut Eingabe abfragen, ohne Spieler zu wechseln
            }
            // ------------------------------

            // Spieler wechseln
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}
