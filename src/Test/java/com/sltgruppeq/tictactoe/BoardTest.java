package com.sltgruppeq.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void test_isFull() {
        assertEquals(false, new Board().isFull());

        Board fullBoard = new Board();
        fullBoard.place(0, 0, 'X');
        fullBoard.place(0, 1, 'X');
        fullBoard.place(0, 2, 'X');

        fullBoard.place(1, 0, 'X');
        fullBoard.place(1, 1, 'X');

        assertEquals(false, fullBoard.isFull());

        fullBoard.place(1, 2, 'X');

        assertEquals(false, fullBoard.isFull());

        fullBoard.place(2, 0, 'X');
        fullBoard.place(2, 1, 'X');
        fullBoard.place(2, 2, 'X');

        assertEquals(true, fullBoard.isFull());
    }

    @Test
    void test_isCellEmpty() {
        Board testBoard = new Board();

        assertEquals(true, testBoard.isCellEmpty(0, 0));

        testBoard.place(0, 0, 'X');

        assertEquals(false, testBoard.isCellEmpty(0, 0));
    }

    @Test
    void test_inValidValues() {
        Board testBoard = new Board();
        testBoard.place(0, 0, 'X');

        assertThrows(IllegalArgumentException.class, () -> testBoard.place(0, 0, 'X'));
    }

    @Test
    void test_BoardInitiallyEmpty() {
        Board board = new Board();
        // Alle Zellen sollten am Anfang leer sein
        assertEquals(true, board.isCellEmpty(0, 0));
        assertEquals(true, board.isCellEmpty(1, 1));
        assertEquals(true, board.isCellEmpty(2, 2));
    }


    @Test //Bereits besetztes Feld wird belegt
    void test_AlreadyOccupiedCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        // Ein zweiter Zug auf dieselbe Zelle ist nicht erlaubt
        assertThrows(IllegalArgumentException.class, () -> board.place(0, 0, 'O'));
    }

    @Test
    void test_clearResetsBoard() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertEquals(true, board.isCellEmpty(0, 0));
    }

    @Test
    void test_isFullreturnsFalsewhenEmpty() {
        Board board = new Board();
        assertEquals(false, board.isFull());
    }


}


