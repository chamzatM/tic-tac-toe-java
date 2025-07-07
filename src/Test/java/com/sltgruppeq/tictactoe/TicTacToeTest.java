package com.sltgruppeq.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TicTacToeTest {
    @Test
    void test_hasWinner(){
        TicTacToe testTicTacToe = new TicTacToe();

        assertFalse(testTicTacToe.hasWinner());

        testTicTacToe.board.place(0, 0, 'X');
        testTicTacToe.board.place(0, 1, 'X');

        assertFalse(testTicTacToe.hasWinner());

        testTicTacToe.board.place(0, 2, 'X');

        assertTrue(testTicTacToe.hasWinner());

    }
    @Test // DiagonalTest
    void test_hasWinner_diagonalWin() {
        TicTacToe game = new TicTacToe();
        game.board.place(0, 0, 'X');
        game.board.place(1, 1, 'X');
        game.board.place(2, 2, 'X');

        assertEquals(true, game.hasWinner());
    }

    @Test // Wenn kein Gewinn -> has Winner returns false
    void test_hasWinner_returnsFalsewhenNoWin() {
        TicTacToe game = new TicTacToe();
        game.board.place(0, 0, 'X');
        game.board.place(0, 1, 'O');
        game.board.place(0, 2, 'X');

        assertEquals(false, game.hasWinner());
    }

    @Test //ob nach switchCurrentPlayer() -> Player eh geswitched wird
    void test_switchCurrentPlayer_switchesPlayer() {
        TicTacToe game = new TicTacToe();

        Player current = game.currentPlayer;
        game.switchCurrentPlayer();
        Player afterSwitch = game.currentPlayer;

        assertNotEquals(current, afterSwitch);
    }


  
}