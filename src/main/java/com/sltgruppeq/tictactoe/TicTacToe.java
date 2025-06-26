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

            try {
                board.place(x, y, currentPlayer.getMarker());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            if (hasWinner()) {
                board.print();
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                break;
            }
            if (board.isFull()) {
                board.print();
                System.out.println("Draw!");
                break;
            }
            switchCurrentPlayer();
        }

        System.out.println("Play again? (y/n)");
        if (sc.next().equalsIgnoreCase("y")) {
            start();
        } else {
            System.out.println("Thanks for playing!");
            sc.close();
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        char m = currentPlayer.getMarker();
        char[][] c = board.cells;

        // Reihen
        for (int i = 0; i < 3; i++)
            if (c[i][0] == m && c[i][1] == m && c[i][2] == m) return true;
        // Spalten
        for (int j = 0; j < 3; j++)
            if (c[0][j] == m && c[1][j] == m && c[2][j] == m) return true;
        // Diagonalen
        if (c[0][0] == m && c[1][1] == m && c[2][2] == m) return true;
        if (c[0][2] == m && c[1][1] == m && c[2][0] == m) return true;

        return false;
    }

    public static void main(String[] args) {
        new TicTacToe().start();
    }
}