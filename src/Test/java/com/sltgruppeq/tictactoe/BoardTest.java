package com.sltgruppeq.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
@Test
    void test_isFull() {
    assertEquals(false,new Board().isFull());

    Board fullBoard = new Board();
    fullBoard.place(0,0,'X');
    fullBoard.place(0,1,'X');
    fullBoard.place(0,2,'X');

    fullBoard.place(1,0,'X');
    fullBoard.place(1,1,'X');

    assertEquals(false, fullBoard.isFull());

    fullBoard.place(1,2,'X');

    assertEquals(false, fullBoard.isFull());

    fullBoard.place(2,0,'X');
    fullBoard.place(2,1,'X');
    fullBoard.place(2,2,'X');

    assertEquals(true, fullBoard.isFull());
}

void test_isCellEmpty() {
    Board testBoard = new Board();

    assertEquals (true, testBoard.isCellEmpty(0,0));

    testBoard.place(0,0,'X');

    assertEquals(false,testBoard.isCellEmpty(0,0));

}

void test_inValidValues(){
    Board testBoard = new Board();
    testBoard.place(0,0,'X');

    assertThrows(IllegalArgumentException.class, () -> testBoard.place(0,0,'X'));
}

}


