package com.sltgruppeq.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class TicTacToeTest {
    @Test
    void test_hasWinner(){
        TicTacToe testTicTacToe = new TicTacToe ();

        assertEquals(false,testTicTacToe.hasWinner());

        TicTacToe.board.place(0,0,'X');
        TicTacToe.board.place(0,1,'X');

        assertEquals(false,testTicTacToe.hasWinner());

        TicTacToe.board.place(0,2,'X');

        assertEquals(true,testTicTacToe.hasWinner());

    }
  
}