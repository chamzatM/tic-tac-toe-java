package com.sltgruppeq.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public Board board = new Board(); //geändert öffentlich (merge Konflikt lokal gelöst
    private final Player player1 = new Player('X');
    private final Player player2 = new Player('O');
    public Player currentPlayer = player1;   // öffentlich (Merge Konflikt lokal gelöst)

    public TicTacToe() { }

    public void start() {
        Scanner sc = new Scanner(System.in);

        do {
            board.clear();
            currentPlayer = player1;

            while (true) {
                board.print();
                System.out.println("Current Player: " + currentPlayer.getMarker());


               int x=0;
                boolean b = true;
                boolean scanagain=false;

              do {
                  b = false;
                  try {
                      if (scanagain) {sc.nextLine();}
                      System.out.print("row (0-2): ");
                      x = sc.nextInt();
                  } catch (InputMismatchException e) {
                      System.out.println("Zahl zwischen 0 und 2 eingeben! Bitte erneut versuchen.");
                      b = true;
                      scanagain = true;
                      continue;

                  }
              }
              while (b);

                int y=0;
                b= true;
                scanagain=false;

                do {
                    b = false;
                    try {
                        if (scanagain){sc.nextLine();}
                        System.out.print("column (0-2): ");
                        y = sc.nextInt();
                    } catch (InputMismatchException e){
                        System.out.println("Zahl zwischen 0 und 2 eingeben! Bitte erneut versuchen.");
                        b = true;
                        scanagain = true;
                        continue;
                    }
                }
                while (b);

                // US-01: Move machen
                try {
                    board.place(x, y, currentPlayer.getMarker());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ungültiger Zug – Feld bereits belegt! Bitte erneut versuchen.");
                    continue;
                }

                // US-03: Sieg prüfen
                if (hasWinner()) {
                    board.print();
                    System.out.println("Spielende: Spieler " + currentPlayer.getMarker() + " hat gewonnen!");
                    break;
                }

                // US-03: Unentschieden prüfen
                if (board.isFull()) {
                    board.print();
                    System.out.println("Unentschieden!");
                    break;
                }

                // Spieler wechseln
                switchCurrentPlayer();
            }

            // --- US-04: Neues Spiel starten ---
            System.out.print("Nochmal spielen? (j/n): ");
        } while (sc.next().equalsIgnoreCase("j"));
        System.out.println("Danke fürs Spielen!");
        sc.close();
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char[][] c = board.cells;

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
